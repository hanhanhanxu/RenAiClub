package cn.renai.controller.Upload;

import cn.renai.Vo.ExamVo;
import cn.renai.pojo.Programe;
import cn.renai.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/UploadExam")
public class UploadExam {

   /* @RequestMapping("/UploadFile")//另一种上传方法，但此法必须要求再SpringMvc中配置multipartResolver，若配置，则第二种方法不能用，因为上传项目是使用的第二种方法，所以不能配置
    public String UploadFile(@RequestParam("file") CommonsMultipartFile files[],
                             ExamVo examVo,
                             HttpServletRequest request,
                             Model model) {

        boolean bo = examVo.validate1();
        if(!bo){
            model.addAttribute("vo",examVo);
            return "/exam.jsp";
        }
        List<String> list = new ArrayList<String>();
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        //为每道题设置特定的文件夹
        String fnamesign = examVo.getSname()+ "_" + examVo.getSid() + "_" + examVo.getClassid();

        for (int i = 0,num=1; i < files.length; i++,num++) {
            // 设定文件保存的目录
            String path = sc.getRealPath("/ExamFiles") + "\\" + "第" + num + "题" + "\\";
//D:\IntelliJ IDEA 2017.3.1\webpro\RenAiClub\out\artifacts\RenAiClub_war_exploded\ExamFiles\第1题
            File f = new File(path);
            if (!f.exists())
                f.mkdirs();

            // 获得原始文件名
            String fileName = files[i].getOriginalFilename();
            System.out.println("原始文件名:" + fileName);
            // 新文件名
            String newFileName = "第" + num + "题@" + fnamesign + "@" + WebUtils.generateID().substring(0,10)  + "@" + fileName;
            //第1题@韩旭_1615925224_软设三班@asdfasdfas45456sdfg@第一题.txt
            System.out.println("新文件名:" + newFileName);
            if (!files[i].isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path
                            + newFileName);
                    InputStream in = files[i].getInputStream();
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("上传图片到:" + path + newFileName);
            list.add(path + newFileName);
        }
        // 保存文件地址，用于JSP页面回显
        model.addAttribute("fileList", list);
        return "redirect:/examover.jsp";
    }*/


    @RequestMapping("/UploadFile")
    public String UploadFile(
                            HttpServletRequest request, HttpServletResponse response ,
                             Model model) {

        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        //上传时生成的临时文件保存目录
        String tempPath = sc.getRealPath("/WEB-INF/ExamTemp");
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //创建临时目录
            tmpFile.mkdir();
        }

        String savePath1 =  sc.getRealPath("/WEB-INF/ExamFiles");//先确定文件的大致保存路径，下面再根据此文件是第几题设置此文件的确切保存路径

        //消息提示
        String message = "";

        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            factory.setSizeThreshold(1024*1024*2);//设置缓冲区的大小为2m，如果不指定，那么缓冲区的大小默认是10KB
            //设置上传时生成的临时文件的保存目录
            factory.setRepository(tmpFile);
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是100MB
            upload.setFileSizeMax(1024*1024*100);
            //设置上传所有文件的总大小最大值
            upload.setSizeMax(1024*1024*1000);
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            int num = 0,count=0;
            ExamVo examVo = new ExamVo();
            String fnamesign = "";
            for(FileItem item : list){
                count++;
                //如果fileitem中封装的不是普通输入项的数据  //如果fileitem中封装的是上传文件
                if(count==1 && item.isFormField()){
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    examVo.setSname(value);
                }
                if(count==2 && item.isFormField()){
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    examVo.setSid(value);
                }
                if(count==3 && item.isFormField()){
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    examVo.setClassid(value);
                }
                if(count>=4){
                    if(count==4){
                        boolean bo = examVo.validate1();
                        if(!bo){
                            model.addAttribute("vo",examVo);
                            return "/exam.jsp";
                        }
                        //为每道题设置特定的文件名
                        fnamesign = examVo.getSname()+ "_" + examVo.getSid() + "_" + examVo.getClassid();
                    }
                    if(!item.isFormField()){
                        num++;//第1，2，3，4...题
                        //得到上传的文件名称，
                        String fileName = item.getName();
                        if(fileName==null || fileName.trim().equals("")){
                            continue;
                        }
                        //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                        //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                        fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                        //得到上传文件的扩展名   限制扩展类型
                        //String fileExtName = filename.substring(filename.lastIndexOf(".")+1);

                        String newFileName = "第" + num + "题@" + fnamesign + "@" + WebUtils.generateID().substring(0,10)  + "@" + fileName;

                        // 设定文件的确切保存目录
                        String savePath = savePath1 + "\\" + "第" + num + "题" + "\\";
                        //D:\IntelliJ IDEA 2017.3.1\webpro\RenAiClub\out\artifacts\RenAiClub_war_exploded\WEB-INF\ExamFiles\第1题
                        File f = new File(savePath);
                        if (!f.exists())
                            f.mkdirs();

                        //获取item中的上传文件的输入流
                        InputStream in = item.getInputStream();
                        //创建一个文件输出流
                        FileOutputStream out = new FileOutputStream(savePath + "\\" + newFileName);

                        //创建一个缓冲区
                        byte buffer[] = new byte[1024];
                        //判断输入流中的数据是否已经读完的标识
                        int len = 0;
                        //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                        while((len=in.read(buffer))>0){
                            //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                            out.write(buffer, 0, len);
                        }
                        //关闭输入流
                        in.close();
                        //关闭输出流
                        out.close();
                        //删除处理文件上传时生成的临时文件
                        item.delete();
                    }
                }
            }
        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "单个文件超过100M！！！");
            return "/exam.jsp";
        }catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
            return "/exam.jsp";
        }catch (Exception e) {
            e.printStackTrace();
            return "/error.jsp";
        }
        return "redirect:/examover.jsp";
    }

}
