package cn.renai.Vo;

import cn.renai.pojo.User;
import cn.renai.pojo.Usersch;

public class UserVo {
    private User pojo;//user基本属性

    private Usersch usersch;//其他属性

    public UserVo() {
    }

    public UserVo(User pojo) {
        this.pojo = pojo;
    }

    public UserVo(Usersch usersch) {

        this.usersch = usersch;
    }

    public UserVo(User pojo, Usersch usersch) {
        this.pojo = pojo;
        this.usersch = usersch;
    }

    public User getPojo() {
        return pojo;
    }

    public void setPojo(User pojo) {
        this.pojo = pojo;
    }

    public Usersch getUsersch() {
        return usersch;
    }

    public void setUsersch(Usersch usersch) {
        this.usersch = usersch;
    }
}
