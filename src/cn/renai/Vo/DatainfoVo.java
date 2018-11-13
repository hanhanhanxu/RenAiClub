package cn.renai.Vo;

import cn.renai.pojo.Datainfo;

public class DatainfoVo {
    Datainfo pojo;
    String cname;

    public Datainfo getPojo() {
        return pojo;
    }

    public void setPojo(Datainfo pojo) {
        this.pojo = pojo;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public DatainfoVo(Datainfo pojo, String cname) {

        this.pojo = pojo;
        this.cname = cname;
    }
}
