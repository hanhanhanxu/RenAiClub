package cn.renai.controller;

import cn.renai.pojo.Programe;
import cn.renai.pojo.Programefield;
import cn.renai.service.ProgrameService;
import cn.renai.service.ProgramecategoryService;
import cn.renai.service.ProgramefieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/Admin3")
public class ProController extends HttpServlet{

    @Autowired
    private ProgrameService programeService;

    @Autowired
    private ProgramecategoryService programecategoryService;

    @Autowired
    private ProgramefieldService programefieldService;

//用户页面功能
//****************************************************************

    @RequestMapping("/GetProById")
    public String GetProById(HttpServletRequest request){
        String id = request.getParameter("id");
        Programe programe = programeService.SelectByid(id);
        request.setAttribute("programe",programe);
         return "/WEB-INF/jsp/GetProById.jsp";
    }

    @RequestMapping("/DownLoadFile")
    public String DownLoadFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Programe programe = programeService.SelectByid(id);

        String path = programe.getFileposition();
        String fileName = programe.getFilename();

        File file = new File(path+"\\"+fileName);
        //如果文件不存在
        if(!file.exists()){
            request.setAttribute("message", "您要下载的资源已被删除！！");
            return "/message.jsp";
        }
        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path + "\\" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
        request.setAttribute("message", "下载成功");
        return "/message.jsp";
    }

    @RequestMapping("/SelectProByFAC")
    public String SelectProByFAC(HttpServletRequest request) throws UnsupportedEncodingException {
        String category = request.getParameter("category");
        String field = request.getParameter("field");
        List<Programe> list =  programeService.ListProBySelect(category,field);
        List<Programefield> programefields = programefieldService.GetAllProCateField();
        request.setAttribute("ListProByCates",list);
        request.setAttribute("ListProField",programefields);
        return "/WEB-INF/jsp/ListProByCates.jsp";
    }

//****************************************************************


}

