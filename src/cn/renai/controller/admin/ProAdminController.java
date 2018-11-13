package cn.renai.controller.admin;

import cn.renai.pojo.Programe;
import cn.renai.pojo.Programecategory;
import cn.renai.pojo.Programefield;
import cn.renai.service.ProgrameService;
import cn.renai.service.ProgramecategoryService;
import cn.renai.service.ProgramefieldService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Admin3")
public class ProAdminController {//针对   “项目分享”   这个大方向的所有操作

    @Autowired
    private ProgrameService programeService;

    @Autowired
    private ProgramecategoryService programecategoryService;

    @Autowired
    private ProgramefieldService programefieldService;


    /* 项目类型 */
//****************************************************************

    //列出所有类型
    @RequestMapping("/ProCategory")
    public String ProCategory(HttpServletRequest request){
        List<Programecategory> list = programecategoryService.GetAllProCate();
        request.setAttribute("Procategorys",list);
        return "/WEB-INF/adminjsp/ProCategory.jsp";
    }

    //添加项目类型
    @RequestMapping("/AddProCate")
    public String AddProCate(Programecategory programecategory,HttpServletRequest request){
        programecategoryService.AddProCate(programecategory);
        List<Programecategory> list = programecategoryService.GetAllProCate();
        request.setAttribute("Procategorys",list);
        return "/WEB-INF/adminjsp/ProCategory.jsp";
    }
    //删除
    @RequestMapping("/DeleteProCate")
    public String DeleteProCate(String id,HttpServletRequest request){
        programecategoryService.DeleteProCate(id);
        List<Programecategory> list = programecategoryService.GetAllProCate();
        request.setAttribute("Procategorys",list);
        return "/WEB-INF/adminjsp/ProCategory.jsp";
    }
    //修改
    @RequestMapping("/ChangeProCate")
    public String ChangeProCate(HttpServletRequest request) throws UnsupportedEncodingException {
        String id = request.getParameter("id");
        String catename = request.getParameter("category");
        //String catename =new String(cate.getBytes("ISO-8859-1"),"UTF-8");

        Programecategory programecategory = new Programecategory(id,catename);

        programecategoryService.UpdateProCate(programecategory);
        List<Programecategory> list = programecategoryService.GetAllProCate();
        request.setAttribute("Procategorys",list);
        return "/WEB-INF/adminjsp/ProCategory.jsp";
    }

//****************************************************************

    /* 项目领域 */
//****************************************************************
    //列出所有领域
    @RequestMapping("/ProCategoryField")
    public String ProCategoryField(HttpServletRequest request){
        List<Programefield> list = programefieldService.GetAllProCateField();
        request.setAttribute("ProCategoryfields",list);
        return "/WEB-INF/adminjsp/ProCategoryField.jsp";
    }

    //添加项目类型
    @RequestMapping("/AddProCateField")
    public String AddProCateField(Programefield programefield,HttpServletRequest request){
        programefieldService.AddProCateField(programefield);
        List<Programefield> list = programefieldService.GetAllProCateField();
        request.setAttribute("ProCategoryfields",list);
        return "/WEB-INF/adminjsp/ProCategoryField.jsp";
    }

    //删除
    @RequestMapping("/DeleteProCateField")
    public String DeleteProCateField(String id,HttpServletRequest request){
        programefieldService.DeleteProCateField(id);
        List<Programefield> list = programefieldService.GetAllProCateField();
        request.setAttribute("ProCategoryfields",list);
        return "/WEB-INF/adminjsp/ProCategoryField.jsp";
    }

    //修改
    @RequestMapping("/ChangeProCateField")
    public String ChangeProCateField(HttpServletRequest request) throws UnsupportedEncodingException {
        String id = request.getParameter("id");
        String fieldname = request.getParameter("field");
        String field =new String(fieldname.getBytes("ISO-8859-1"),"UTF-8");

        Programefield programefield = new Programefield(id,field);

        programefieldService.UpdateProCateField(programefield);
        List<Programefield> list = programefieldService.GetAllProCateField();
        request.setAttribute("ProCategoryfields",list);
        return "/WEB-INF/adminjsp/ProCategoryField.jsp";
    }


//****************************************************************

    /* 项目管理 */
//****************************************************************

    //添加项目 1 列表选项
    @RequestMapping("/AddPro")
    public String AddPro(HttpServletRequest request){
        List<Programecategory> list = programecategoryService.GetAllProCate();
        List<Programefield> list2 = programefieldService.GetAllProCateField();
        request.setAttribute("ProCate",list);
        request.setAttribute("Profield",list2);
        return "/WEB-INF/adminjsp/AddPro.jsp";
    }

    /*
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            String title = multipartRequest.getParameter("title");
            paramer.add(title);
            String content = multipartRequest.getParameter("content");
            paramer.add(content);
            String category = multipartRequest.getParameter("category");
            paramer.add(category);
            String field = multipartRequest.getParameter("field");
            paramer.add(field);
            String href = multipartRequest.getParameter("href");
            paramer.add(href);
            String password = multipartRequest.getParameter("password");
            paramer.add(password);
    */

    //添加项目 2 文件上传
    @RequestMapping("/UpLoadPro")
    public String UpLoadPro(String href,HttpServletRequest request, HttpServletResponse response){

        Programe p = new Programe();
        List<String> paramer= new ArrayList();
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = "D:\\IdearPrograme\\RenAiClub\\web\\WEB-INF\\upload";
        //上传时生成的临时文件保存目录
        String tempPath = "D:\\IdearPrograme\\RenAiClub\\web\\WEB-INF\\temp";
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //创建临时目录
            tmpFile.mkdir();
        }

        //消息提示
        String message = "";
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            factory.setSizeThreshold(1024*1024*10);//设置缓冲区的大小为10m，如果不指定，那么缓冲区的大小默认是10KB
            //设置上传时生成的临时文件的保存目录
            factory.setRepository(tmpFile);
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                message="不是上传表单数据";
                return "/WEB-INF/adminjsp/AddPro.jsp";
            }

            //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是100MB
            upload.setFileSizeMax(1024*1024*100);
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    paramer.add(value);
                }else{//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    String filename = item.getName();
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\")+1);

                    /*得到上传文件的扩展名
                    String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                    限制扩展类型
                     */

                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //得到文件的保存目录
                    String realSavePath = makePath(filename, savePath);
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(realSavePath + "\\" + filename);

                    p.setFilename(filename);
                    p.setFileposition(realSavePath);

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
                    message = "文件上传成功！";
                }
            }
        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "单个文件超出最大值！！！");
            return "/WEB-INF/adminjsp/AddPro.jsp";
        }catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
            return "/WEB-INF/adminjsp/AddPro.jsp";
        }catch (Exception e) {
            message= "文件上传失败！";
            e.printStackTrace();
        }
        request.setAttribute("message",message);
        p.setTitle(paramer.get(0));
        p.setContent(paramer.get(1));
        p.setCategory(paramer.get(2));
        p.setField(paramer.get(3));
        if(paramer.get(4)!=null){
            p.setHref(paramer.get(4));
            p.setPassword(paramer.get(5));
        }
        programeService.insertprocategory(p);

        return "/UIAdmin/WebSet.action";
    }


    private String makePath(String filename,String savePath){
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        //如果目录不存在
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }

    //列出所有项目
    @RequestMapping("/ListPro")
    public String LookPro(HttpServletRequest request){
        List<Programe> list =  programeService.getall();
        List<Programecategory> list2 = programecategoryService.GetAllProCate();
        List<Programefield> list3 = programefieldService.GetAllProCateField();
        list2.add(new Programecategory("All","All"));
        list3.add(new Programefield("All","All"));
        request.setAttribute("ListPro",list);
        request.setAttribute("ProCate",list2);
        request.setAttribute("Profield",list3);
        return "/WEB-INF/adminjsp/ListPro.jsp";
    }

    //检索
    @RequestMapping("/ListProBySelect")
    public String ListProBySelect(HttpServletRequest request) throws UnsupportedEncodingException {
        String category = request.getParameter("category");
        String field = request.getParameter("field");

        List<Programe> list = null;
        List<Programecategory> list2 = null;
        List<Programefield> list3 = null;
        if (category.equals("All") && field.equals("All")){
            list = programeService.getall();
        }else if(category.equals("All") && field.equals("All")!=true ){
            list = programeService.ListProBySelectField(field);
        }else if(field.equals("All") && category.equals("All")!=true){
            list = programeService.ListProBySelectCate(category);
        }else {
            list = programeService.ListProBySelect(category,field);
        }
        list2 = programecategoryService.GetAllProCate();
        list3 = programefieldService.GetAllProCateField();
        list2.add(new Programecategory("All","All"));
        list3.add(new Programefield("All","All"));
        request.setAttribute("ListPro",list);
        request.setAttribute("ProCate",list2);
        request.setAttribute("Profield",list3);
        return "/WEB-INF/adminjsp/ListPro.jsp";
    }

    //详情
    @RequestMapping("/SelectById")
    public String SelectById(HttpServletRequest request){
        String id = request.getParameter("id");
        Programe programe = programeService.SelectByid(id);
        request.setAttribute("programe",programe);
        return "/WEB-INF/adminjsp/SelectByIdOne.jsp";
    }
    //修改
    @RequestMapping("/ChangPro")
    public String ChangPro(Programe programe,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(programeService.UpdateProcategory(programe)){
            programe = programeService.SelectByid(programe.getId().toString());
            request.setAttribute("programe",programe);
            request.setAttribute("p","p");
            return "/WEB-INF/adminjsp/SelectByIdOne.jsp";
        }else {
            request.setAttribute("message","修改失败");
            return "/WEB-INF/adminjsp/message.jsp";
        }
    }

    //删除
    @RequestMapping("/DeletePro")
    public String DeletePro(HttpServletRequest request){
        String id = request.getParameter("id");
        Programe programe =  programeService.SelectByid(id);
        //删除文件
        if(programe.getFileposition()!="" && programe.getFileposition()!=null){
            String fileName = programe.getFileposition()+"//"+programe.getFilename();
            File file = new File(fileName);
            file.delete();
        }
        programeService.DeleteProcategory(id);
        List<Programe> list =  programeService.getall();
        List<Programecategory> list2 = programecategoryService.GetAllProCate();
        List<Programefield> list3 = programefieldService.GetAllProCateField();
        list2.add(new Programecategory("All","All"));
        list3.add(new Programefield("All","All"));
        request.setAttribute("ListPro",list);
        request.setAttribute("ProCate",list2);
        request.setAttribute("Profield",list3);
        return "/WEB-INF/adminjsp/ListPro.jsp";
    }
//****************************************************************


}
