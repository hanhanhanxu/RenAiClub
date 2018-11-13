package cn.renai.pojo;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String uid;

    private String username;

    private String password;

    private String password2;

    private String nickname;

    private String tel;

    private String qq;

    private String classid;

    private String entrance;

    private String sex;

    private String introduce;

    private Integer admin;

    private String checkcode;

    private Map<String,String> errors = new HashMap<String,String>();

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance == null ? null : entrance.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public boolean validate3() {
        boolean isOK = true;
        if(nickname==null || nickname.trim().equals("")) {
            isOK = false;
            errors.put("nickname", "昵称不能为空！");
        }else {
            if(!this.nickname.matches("[\u4e00-\u9fa5]{1,10}")) {
                isOK = false;
                errors.put("nickname", "昵称必须是1-10个汉字！");
            }
        }

        if(tel!=null && !tel.trim().equals("")){//存在值时
            if(!this.tel.matches("[1][3578]\\d{9}")){
                isOK = false;
                errors.put("tel", "手机号格式不正确！");
            }
        }

        if(qq!=null && !qq.trim().equals("")){//存在值时
            if(!this.qq.matches("[1-9][0-9]{4,14}")){
                isOK = false;
                errors.put("qq", "QQ号格式不正确！");
            }
        }

        return isOK;
    }

    public boolean validate2(){//登录校验
        boolean isOK = true;
        if(username==null || username.trim().equals("")) {
            isOK = false;
            errors.put("username", "登录账号不能为空！");
        }
        if(password==null || password.trim().equals("")) {
            isOK = false;
            errors.put("password", "登录密码不能为空！");
        }
        return isOK;
    }

    public boolean validate1() {
        boolean isOK = true;

        if(username==null || username.trim().equals("")) {
            isOK = false;
            errors.put("username", "登录账号不能为空！");
        }else {
            if(!this.username.matches("\\d{6,11}")) {//登录账号必须为6-11位数字
                isOK = false;
                errors.put("username", "登录账号必须为6-11位数字！");
            }
        }

        if(password==null || password.trim().equals("")) {
            isOK = false;
            errors.put("password", "登录密码不能为空！");
        }else {
            if(!this.password.matches("[A-Za-z0-9]{6,11}")) {//登录密码必须为6-11位数字或字母或其组合
                isOK = false;
                errors.put("password", "登录密码必须为6-11位数字或字母或其组合,不能包含其他符号！");
            }
        }

        if(password2==null || password2.trim().equals("")) {
            isOK = false;
            errors.put("password2", "确认密码不能为空！");
        }else {
            if(!password2.equals(password)) {
                isOK = false;
                errors.put("password2", "两次输入密码不一致！");
            }
        }

        if(nickname==null || nickname.trim().equals("")) {
            isOK = false;
            errors.put("nickname", "昵称不能为空！");
        }else {
            if(!this.nickname.matches("[\u4e00-\u9fa5]{1,10}")) {
                isOK = false;
                errors.put("nickname", "昵称必须是1-10个汉字！");
            }
        }

        if(checkcode==null || checkcode.trim().equals("")) {
            isOK = false;
            errors.put("checkcode", "验证码不能为空！");
        }

        if(tel!=null && !tel.trim().equals("")){//存在值时
            if(!this.tel.matches("[1][3578]\\d{9}")){
                isOK = false;
                errors.put("tel", "手机号格式不正确！");
            }
        }

        if(qq!=null && !qq.trim().equals("")){//存在值时
            if(!this.qq.matches("[1-9][0-9]{4,14}")){
                isOK = false;
                errors.put("qq", "QQ号格式不正确！");
            }
        }


        return isOK;
    }
}