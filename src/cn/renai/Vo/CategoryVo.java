package cn.renai.Vo;

import cn.renai.pojo.Category;

public class CategoryVo {
    Category pojo;
    String mname;

    public CategoryVo(Category pojo, String mname) {
        this.pojo = pojo;
        this.mname = mname;
    }

    public Category getPojo() {
        return pojo;
    }

    public void setPojo(Category pojo) {
        this.pojo = pojo;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
