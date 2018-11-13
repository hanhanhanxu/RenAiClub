package cn.renai.controller.UI;

import cn.renai.pojo.Programe;
import cn.renai.pojo.Programefield;
import cn.renai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/UILoad")
public class UILoad {//搞定页面加载之类的东西，加载 大一学习 大二学习这些

    @Autowired
    private ModularService modularService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProgrameService programeService;
    @Autowired
    private ProgramefieldService programefieldService;
    @Autowired
    private ProgramecategoryService programecategoryService;
    @Autowired
    private  ClassInfoService classInfoService;
    @Autowired
    private EntranceYearService entranceYearService;


    //***************************************首页加载
    @RequestMapping("/LoadIndex")
    public String LoadIndex(HttpServletRequest request,HttpSession session){
        List list = modularService.queryAll();
        request.setAttribute("modularItems",list);

        List programecategory = programecategoryService.GetAllProCate();
        request.setAttribute("ProCate",programecategory);

        //session.setAttribute("modularItems",list);
        return "/index.jsp";
    }

    //首页点击“大一学习”/“大二学习”/“大三学习”进入此controller判断
    @RequestMapping("/Data")
    public String LoadData(String mid, HttpSession session){
        List list = categoryService.queryByModular_id(mid);
        session.setAttribute("categoryItems",list);
        String mname = modularService.QueryByMid(mid).getName();
        session.setAttribute("mname",mname);
        return "/WEB-INF/jsp/data.jsp";
    }

    //首页点击“仁爱工作室”/“开源项目”进入此controller判断
    @RequestMapping("/Admin3")
    public String LoadPro(String category,HttpSession session,HttpServletRequest request){
        session.setAttribute("categoryname",category);

        List<Programe> list =  programeService.ListProBySelectCate(category);
        List<Programefield> programefields = programefieldService.GetAllProCateField();
        request.setAttribute("ListProByCates",list);
        request.setAttribute("ListProField",programefields);
        return "/WEB-INF/jsp/ListProByCates.jsp";
    }



    //**************************************注册页面加载
    @RequestMapping("/LoadRegist")
    public String LoadRegist(HttpSession session){
        List list = classInfoService.queryAll();
        session.setAttribute("ClassInfo",list);
        List list2 = entranceYearService.queryAll();
        session.setAttribute("EntranceYear",list2);
        return "/WEB-INF/jsp/regist.jsp";
    }

    @RequestMapping("/CompletionInfo")
    public String CompletionInfo(HttpSession session){
        if(session.getAttribute("user")==null)
            return "/WEB-INF/jsp/error.jsp";
        return "/WEB-INF/jsp/CompletionInfo.jsp";
    }

    @RequestMapping("/ModifyPass")
    public String ModifyPass(HttpSession session){
        if(session.getAttribute("user")==null)
            return "/WEB-INF/jsp/error.jsp";
        return "/WEB-INF/jsp/ModifyPass.jsp";
    }

    @RequestMapping("/exam")
    public String LoadExam(HttpSession session){
        List list = classInfoService.queryAll();
        session.setAttribute("ClassInfo",list);
        return "/exam.jsp";
    }
}
