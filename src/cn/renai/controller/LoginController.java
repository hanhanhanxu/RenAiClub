package cn.renai.controller;

import cn.renai.pojo.User;
import cn.renai.pojo.UserSecurity;
import cn.renai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/LoginAndRegist")
public class LoginController {

    //注入userService对象
    @Autowired
    public UserService userService;


    @RequestMapping("/regist")
    public String regist(HttpSession session,HttpServletRequest request,String checkcode, User user, Model model){
        String checkcode2 = (String)request.getServletContext().getAttribute("checkcode2");
        request.getServletContext().removeAttribute("checkcode2");
        //其他非空校验
        if(!user.validate1()){
            model.addAttribute("form",user);
            return "/WEB-INF/jsp/regist.jsp";
        }
        //校验验证码
        if(!checkcode2.equals(checkcode)){
            user.getErrors().put("checkcode","验证码输入不正确");
            model.addAttribute("form",user);
            return "/WEB-INF/jsp/regist.jsp";
        }
        //校验账号是否重复
        if(userService.checkUsernameForRegist(user.getUsername())==true){
            userService.addUserForRegist(user);
            model.addAttribute("message","注册成功，请登录！");
            session.setAttribute("ClassInfo",null);
            session.setAttribute("EntranceYear",null);
            return "/WEB-INF/jsp/login.jsp";
        }else{
            user.getErrors().put("username","账号已存在！");
            model.addAttribute("form",user);
            return "/WEB-INF/jsp/regist.jsp";
        }
    }
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session){
        //其他非空校验
        if(!user.validate2()){
            model.addAttribute("form",user);
            return "/WEB-INF/jsp/login.jsp";
        }
        //utrue包含此user的全部信息 select * from user ... ; user中只包含username和password
        User userAllInfo = userService.checkUserForLogin(user);
        //账号密码匹配性校验
        if(userAllInfo==null){
            model.addAttribute("message","账户信息输入有误！");
            return "/WEB-INF/jsp/login.jsp";
        }else{
            session.setAttribute("user",userAllInfo);
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping("/unsubscribe")//退出
    public String unsubscribe(HttpSession session){
        session.setAttribute("user",null);
        //session.removeAttribute("user"); 不能remove,移除后首页就不显示“登录/注册”了
        //先设置为空，再重定向，否则浏览器缓存中还存在此user。
        return "redirect:/index.jsp";
    }

    @RequestMapping("/seachAccount")
    public String seachAccount(String username, Model model,HttpSession session){
        User u = userService.getUserByUsername(username);
        if(u==null){
            model.addAttribute("message","账号错误！");
            return "/WEB-INF/jsp/FindPass.jsp";
        }
        UserSecurity userSecurity = userService.checkUserSecurityByUid(u.getUid());
        if(userSecurity==null || "?".equals(userSecurity.getQuestion()) || userSecurity.getAnswer()==null){
            model.addAttribute("message","您没有设置密保问题！");
            return "/WEB-INF/jsp/FindPass.jsp";
        }

        session.setAttribute("user",u);
        UserSecurity uSecurity = new UserSecurity();
        uSecurity.setQuestion(userSecurity.getQuestion());
        model.addAttribute("userSecurity",uSecurity);
        return "/WEB-INF/jsp/FindPass.jsp";
    }

    @RequestMapping("/findAccount")
    public String findAccount(HttpSession session,Model model,UserSecurity userSecurity){
        User u = (User) session.getAttribute("user");
        UserSecurity uSecurity = userService.checkUserSecurityByUid(u.getUid());
        if(uSecurity.getQuestion().equals(userSecurity.getQuestion()) && uSecurity.getAnswer().equals(userSecurity.getAnswer())){
            return "/WEB-INF/jsp/resetPass.jsp";
        }else{
            model.addAttribute("message2","答案填写错误！");
            return "/WEB-INF/jsp/FindPass.jsp";
        }
    }
}
