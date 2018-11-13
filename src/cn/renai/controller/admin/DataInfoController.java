package cn.renai.controller.admin;

import cn.renai.Vo.CategoryVo;
import cn.renai.Vo.DatainfoVo;
import cn.renai.pojo.*;
import cn.renai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class DataInfoController {//针对   “学习资料”   这个大方向的所有操作

    @Autowired
    private ModularService modularService;//模块
    @Autowired
    private CategoryService categoryService;//类别
    @Autowired
    private DataInfoService dataInfoService;//学习资料
    @Autowired
    private ClassInfoService classInfoService;//班级信息
    @Autowired
    private EntranceYearService entranceYearService;//入学年份信息

    //*****************************对   模块  的操做
    @RequestMapping("/AddModular")//添加模块
    public String AddModular(Modular modular, Model model){
        modularService.addModular(modular);
        model.addAttribute("warning","添加成功!");
        return "/WEB-INF/adminjsp/adminWebSet.jsp";
    }
    @RequestMapping("/ListModular")//查看模块
    public String ListModular(Model model){
        List list = modularService.queryAll();
        if(list==null){
            model.addAttribute("warning","暂无任何模块，请先添加!");
            return "/WEB-INF/adminjsp/adminWebSet.jsp";
        }else{
            model.addAttribute("list",list);
            return "/WEB-INF/adminjsp/ListModular.jsp";
        }
    }
    @RequestMapping("/DeleteModular")//删除模块
    public String DeleteModular(String modular_id){
        modularService.deleteModular(modular_id);
        return "/Admin/ListModular.action";
    }

    //*****************************对   分类  的操做
    @RequestMapping("/AddCategory")
    public String AddCategory(Category category, Model model){
        categoryService.addCategory(category);
        model.addAttribute("warning","添加成功!");
        return "/WEB-INF/adminjsp/adminWebSet.jsp";
    }
    @RequestMapping("/ListCategory")
    public String ListCategory(Model model){
        List<Category> list = categoryService.queryAll();
        if(list==null){
            model.addAttribute("warning","暂无任何分类，请先添加!");
            return "/WEB-INF/adminjsp/adminWebSet.jsp";
        }else{
            List<CategoryVo> listVo = new ArrayList<CategoryVo>();
            String mname = "" ;
            //包装好需要展示的Vo
            for(Category l:list){
                mname = modularService.QueryByMid(l.getModularId()).getName();
                listVo.add(new CategoryVo(l,mname));
            }
            model.addAttribute("list",listVo);
            return "/WEB-INF/adminjsp/ListCategory.jsp";
        }
    }
    @RequestMapping("/DeleteCategory")
    public String DeleteCategory(String category_id){
        categoryService.deleteCategory(category_id);
        return "/Admin/ListCategory.action";
    }
    @RequestMapping("/UpdateCategory")
    public String UpdateCategory(Category category){
        categoryService.updateCategory(category);
        return "/Admin/ListCategory.action";
    }

    //*****************************对   资料  的操做
    @RequestMapping("/AddDataInfo")
    public String AddDataInfo(Datainfo datainfo, Model model){
        dataInfoService.addDataInfo(datainfo);
        model.addAttribute("warning","添加成功!");
        return "/WEB-INF/adminjsp/adminWebSet.jsp";
    }
    @RequestMapping("/ListDataInfo")
    public String ListDataInfo(Model model){
        List<Datainfo> list = dataInfoService.queryAll();
        if(list==null){
            model.addAttribute("warning","暂无任何资料，请先添加!");
            return "/WEB-INF/adminjsp/adminWebSet.jsp";
        }else{
            List<DatainfoVo> listVo = new ArrayList<DatainfoVo>();
            String cname = "";
            //包装好需要展示的Vo
            for(Datainfo l:list){
                cname = categoryService.QueryByCid(l.getCategoryId()).getName();
                listVo.add(new DatainfoVo(l,cname));
            }
            model.addAttribute("list",listVo);
            return "/WEB-INF/adminjsp/ListDataInfo.jsp";
        }
    }
    @RequestMapping("/DeleteDatainfo")
    public String DeleteDatainfo(String datainfo_id){
        dataInfoService.deleteCategory(datainfo_id);
        return "/Admin/ListDataInfo.action";
    }


    //*****************************对   班级信息  的操做
    @RequestMapping("/AddClassInfo")
    public String AddClassInfo(Classinfo classinfo, Model model){
        classInfoService.addClassInfo(classinfo);
        model.addAttribute("warning","添加成功!");
        return "/WEB-INF/adminjsp/adminWebSet.jsp";
    }
    @RequestMapping("/ListClassInfo")
    public String ListClassInfo(Model model){
        List<Classinfo> list = classInfoService.queryAll();
        if(list==null){
            model.addAttribute("warning","暂无任何班级信息，请先添加!");
            return "/WEB-INF/adminjsp/adminWebSet.jsp";
        }else{
            model.addAttribute("list",list);
            return "/WEB-INF/adminjsp/ListClassInfo.jsp";
        }
    }
    @RequestMapping("/DeleteClassinfo")
    public String DeleteClassinfo(String classinfo_id){
        classInfoService.deleteClassInfo(classinfo_id);
        return "/Admin/ListClassInfo.action";
    }

    //*****************************对   入学年份选项  的操做
    @RequestMapping("/AddEntranceYear")
    public String AddEntranceYear(Entranceyear entranceyear, Model model){
        entranceYearService.addYear(entranceyear);
        model.addAttribute("warning","添加成功!");
        return "/WEB-INF/adminjsp/adminWebSet.jsp";
    }
    @RequestMapping("/ListEntranceYear")
    public String ListEntranceYear(Model model){
        List<Entranceyear> list = entranceYearService.queryAll();
        if(list==null){
            model.addAttribute("warning","暂无任何年份信息，请先添加!");
            return "/WEB-INF/adminjsp/adminWebSet.jsp";
        }else{
            model.addAttribute("list",list);
            return "/WEB-INF/adminjsp/ListEntranceYear.jsp";
        }
    }
    @RequestMapping("/DeleteEntranceYear")
    public String DeleteEntranceYear(String entranceyear_id){
        entranceYearService.deleteYear(entranceyear_id);
        return "/Admin/ListEntranceYear.action";
    }

}
