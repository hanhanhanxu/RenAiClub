package cn.renai.Vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExamVo {
    private String sname;
    private String sid;
    private String classid;
    private Map<String,String> errors = new HashMap<String,String>();

    public boolean validate1(){
        boolean isOK = true;
        if(sname==null || "".equals(sname.trim())){
            errors.put("sname","姓名不能为空！");
            isOK = false;
        }else if(!sname.matches("[\\u4e00-\\u9fa5]{2,8}")){
            errors.put("sname","姓名必须为汉字！");
            isOK = false;
        }

        if(sid==null || "".equals(sid)){
            errors.put("sid","学号不能为空！");
            isOK = false;
        }else if(!sid.matches("\\d{10}")){
            errors.put("sid","学号必须为10为数字！");
            isOK = false;
        }

        return isOK;
    }

    public ExamVo() {
    }

    public ExamVo(String sname, String sid, String classid) {

        this.sname = sname;
        this.sid = sid;
        this.classid = classid;
    }


    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }


    public String getSname() {

        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
}
