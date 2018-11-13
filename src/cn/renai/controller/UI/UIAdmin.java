package cn.renai.controller.UI;

import cn.renai.Vo.CategoryVo;
import cn.renai.Vo.UserVo;
import cn.renai.pojo.Category;
import cn.renai.pojo.User;
import cn.renai.service.CategoryService;
import cn.renai.service.ModularService;
import cn.renai.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/UIAdmin")
public class UIAdmin {

    @Autowired
    private UserService userService;
    @Autowired
    private ModularService modularService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/WebSet")//去  网站管理 页面
    public String WebSet(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
        if(u.getAdmin()!=1){
            model.addAttribute("error","非管理员用户！");
            return "/error.jsp";
        }

        return "/WEB-INF/adminjsp/adminWebSet.jsp";
    }

    @RequestMapping("/InfoSet")//去  身份管理 页面
    public String InfoSet(HttpServletRequest request){
        List<User> list = userService.getAllUser();
        List listVo = new ArrayList();
        for(User u:list){
            UserVo vo = new UserVo();
            vo.setPojo(u);
            vo.setUsersch(userService.getUsersch(u.getUid()));
            listVo.add(vo);
        }
        request.setAttribute("users",listVo);
        return "/WEB-INF/adminjsp/adminInfoSet.jsp";
    }


    //*****************************  学习资料模块的跳转  ************************************


    @RequestMapping("/addModular")//去  添加模块 页面
    public String addModular(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
        if(u.getAdmin()!=1){
            model.addAttribute("error","非管理员用户！");
            return "/error.jsp";
        }

        return "/WEB-INF/adminjsp/addModular.jsp";
    }

    @RequestMapping("/addCategory")//去   添加分类 页面
    public String addCategory(HttpSession session, Model model,HttpServletRequest request){
        User u = (User) session.getAttribute("user");
        if(u.getAdmin()!=1){
            model.addAttribute("error","非管理员用户！");
            return "/error.jsp";
        }

        List list = modularService.queryAll();
        request.setAttribute("modular",list);
        return "/WEB-INF/adminjsp/addCategory.jsp";
    }

    @RequestMapping("/addDataInfo")//去   添加资料 页面
    public String addDataInfo(HttpSession session, Model model,HttpServletRequest request){
        User u = (User) session.getAttribute("user");
        if(u.getAdmin()!=1){
            model.addAttribute("error","非管理员用户！");
            return "/error.jsp";
        }

        List list = categoryService.queryAll();
        request.setAttribute("category",list);
        return "/WEB-INF/adminjsp/addDataInfo.jsp";
    }

    @RequestMapping("/updateCategory")//去   修改分类  页面
    public String updateCategory(HttpSession session, Model model,String cid,HttpServletRequest request){
        User u = (User) session.getAttribute("user");
        if(u.getAdmin()!=1){
            model.addAttribute("error","非管理员用户！");
            return "/error.jsp";
        }

        Category category = categoryService.QueryByCid(cid);//此分类的信息
        String mname = modularService.QueryByMid(category.getModularId()).getName();//此分类所属的模块的名字
        CategoryVo categoryVo = new CategoryVo(category,mname);
        request.setAttribute("item",categoryVo);
        request.setAttribute("modulars",modularService.queryAll());
        return "/WEB-INF/adminjsp/updateCategory.jsp";
    }


    //*****************************  项目分享模块的跳转  ************************************
    @RequestMapping("/addProCate")//去    添加项目类型  页面
    public String addProCate(){
        return "/WEB-INF/adminjsp/AddProCate.jsp";
    }

    @RequestMapping("/addProCateField")//去    添加项目领域  页面
    public String addProCateField(){
        return "/WEB-INF/adminjsp/AddProCateField.jsp";
    }


    //*****************************  其他跳转  ************************************

    @RequestMapping("/addClassInfo")
    public String addClassInfo(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
        if(u.getAdmin()!=1){
            model.addAttribute("error","非管理员用户！");
            return "/error.jsp";
        }


        return "/WEB-INF/adminjsp/addClassInfo.jsp";
    }

    @RequestMapping("/addEntranceYear")
    public String addEntranceYear(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
        if(u.getAdmin()!=1){
            model.addAttribute("error","非管理员用户！");
            return "/error.jsp";
        }

        return "/WEB-INF/adminjsp/addEntranceYear.jsp";
    }
}
