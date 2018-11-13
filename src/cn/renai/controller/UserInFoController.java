package cn.renai.controller;

import cn.renai.pojo.User;
import cn.renai.pojo.UserSecurity;
import cn.renai.service.UserService;
import cn.renai.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/UserInFo")
public class UserInFoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/Completion")
    public String Completion(HttpSession session, User user, UserSecurity userSecurity, Model model){
        User u = (User) session.getAttribute("user");//取得session域中的登录用户的信息

        //校验合格
        if(!user.validate3()){
            model.addAttribute("user",user);
            return "/WEB-INF/jsp/CompletionInfo.jsp";
        }

        userService.modifyUinfoByUser(u,user);

        userSecurity.setUserId(u.getUid());//包装好这个userSecurity
        userService.setSecurityQuestion(userSecurity);//插入密保问题

        //更新session域中的user信息
        session.setAttribute("user",userService.getUserById(u.getUid()));
        model.addAttribute("message","信息更新完成!");
        return "/WEB-INF/jsp/CompletionInfo.jsp";
    }

    @RequestMapping("/ModifyPass")
    public String ModifyPass(HttpSession session,User user, String oldPass, Model model){
        User u = (User) session.getAttribute("user");//取得session域中的登录用户的信息
        String uid = u.getUid();//得到修改所需要的此用户的uid

        if(!u.getPassword().equals(WebUtils.md5(oldPass))){//旧密码填写不正确
            model.addAttribute("message","旧密码填写错误");
            return "/WEB-INF/jsp/ModifyPass.jsp";
        }
        //新密码校验
        if(user.getPassword()==null || user.getPassword().trim().equals("")){
            model.addAttribute("message","密码不能为空");
            return "/WEB-INF/jsp/ModifyPass.jsp";
        }
        if(!user.getPassword().equals(user.getPassword2())){
            model.addAttribute("message","两次密码不一致");
            return "/WEB-INF/jsp/ModifyPass.jsp";
        }
        if(!user.getPassword().matches("[A-Za-z0-9]{6,11}")){
            model.addAttribute("message","登录密码必须为6-11位数字或字母或其组合,不能包含其他符号！");
            return "/WEB-INF/jsp/ModifyPass.jsp";
        }
        user.setUid(uid);//此user中只有 id 新password
        userService.modifyPassword(user);//修改数据库中的密码信息
        model.addAttribute("message","修改密码成功,请重新登录");
        return "/WEB-INF/jsp/login.jsp";
    }

    @RequestMapping("/resetPass")
    public String resetPass(HttpSession session,Model model,String password,String password2){
        if(password==null || password.trim().equals("") || !password.equals(password2)){
            model.addAttribute("message","两次密码不一致");
            return "/WEB-INF/jsp/resetPass.jsp";
        }
        if(!password.matches("[A-Za-z0-9]{6,11}")){
            model.addAttribute("message","登录密码必须为6-11位数字或字母或其组合,不能包含其他符号！");
            return "/WEB-INF/jsp/resetPass.jsp";
        }
        User u = (User)session.getAttribute("user");
        User user = new User();
        user.setUid(u.getUid());
        user.setPassword(password);
        userService.modifyPassword(user);
        session.setAttribute("user",null);
        model.addAttribute("message","修改成功，请登录");
        return "/UILogin/login.action";
    }
}
