package cn.renai.pojo;

public class Usersch {
    private String uSc;

    private String uId;

    private Integer isrenai;

    private Integer scha;

    private Integer schb;

    private Integer schc;

    private Integer schd;

    private Integer sche;

    public String getuSc() {
        return uSc;
    }

    public void setuSc(String uSc) {
        this.uSc = uSc == null ? null : uSc.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public Integer getIsrenai() {
        return isrenai;
    }

    public void setIsrenai(Integer isrenai) {
        this.isrenai = isrenai;
    }

    public Integer getScha() {
        return scha;
    }

    public void setScha(Integer scha) {
        this.scha = scha;
    }

    public Integer getSchb() {
        return schb;
    }

    public void setSchb(Integer schb) {
        this.schb = schb;
    }

    public Integer getSchc() {
        return schc;
    }

    public void setSchc(Integer schc) {
        this.schc = schc;
    }

    public Integer getSchd() {
        return schd;
    }

    public void setSchd(Integer schd) {
        this.schd = schd;
    }

    public Integer getSche() {
        return sche;
    }

    public void setSche(Integer sche) {
        this.sche = sche;
    }
}