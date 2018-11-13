package cn.renai.pojo;

public class Classinfo {
    private String cIId;

    private String classnum;

    private String classname;

    public String getcIId() {
        return cIId;
    }

    public void setcIId(String cIId) {
        this.cIId = cIId == null ? null : cIId.trim();
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum == null ? null : classnum.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }
}