package cn.renai.controller;

import cn.renai.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/DataInfo")
public class DataController {

    @Autowired
    private DataInfoService dataInfoService;

    @RequestMapping("/GetInfo")
    public String info1(String cid,HttpServletRequest request){
        List list = dataInfoService.queryByCategory_id(cid);
        request.setAttribute("datainfoItems",list);
        return "/WEB-INF/jsp/data.jsp";
    }
}
