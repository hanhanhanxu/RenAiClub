package cn.renai.controller.admin;

import cn.renai.Vo.UserVo;
import cn.renai.pojo.User;
import cn.renai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Admin2")//进入Admin2这些都要加验证session域中是否存在admin信息
public class UserInfoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryByDouble")
    public String queryByDouble(String username, String nickname, HttpServletRequest request){
        List<User> list = userService.queryUserByDouble(username,nickname);
        List<UserVo> listVo = new ArrayList<>();
        if(list!=null)
        for(User u : list){
            UserVo vo = new UserVo();
            vo.setPojo(u);
            vo.setUsersch(userService.getUsersch(u.getUid()));
            listVo.add(vo);
        }
        request.setAttribute("users",listVo);
        return "/WEB-INF/adminjsp/adminInfoSet.jsp";
    }

    @RequestMapping("/joinRenAii")
    public String joinRenAii(String uid){
        userService.joinRenai(uid);
        return "/UIAdmin/InfoSet.action";
    }

    @RequestMapping("/removeRenAii")
    public String removeRenAii(String uid){
        userService.removeRenai(uid);
        return "/UIAdmin/InfoSet.action";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(String uid){
        userService.deleteUserByUid(uid);
        return "/UIAdmin/InfoSet.action";
    }

}
