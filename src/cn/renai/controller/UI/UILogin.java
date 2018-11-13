package cn.renai.controller.UI;

import cn.renai.pojo.User;
import cn.renai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/UILogin")
public class UILogin {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "/WEB-INF/jsp/login.jsp";
    }//转到login.jsp

    @RequestMapping("/regist")
    public String regist(){
        return "/WEB-INF/jsp/regist.jsp";
    }

    @RequestMapping("/ToMyInfo")
    public String ToMyInfo(HttpSession session){
        User user= (User)session.getAttribute("user");
        if(user.getAdmin()==0){
            return "/WEB-INF/jsp/myinfo.jsp";
        }
        else if (user.getAdmin()==1){
            return "/WEB-INF/adminjsp/adminIndex.jsp";
        }else{
            return "/WEB-INF/jsp/error.jsp";
        }
    }

    @RequestMapping("/FindPass")
    public String FindPass(){
        return "/WEB-INF/jsp/FindPass.jsp";
    }


}
