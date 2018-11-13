package cn.renai.pojo;

public class Datainfo {
    private String did;

    private String name;

    private String infourl;

    private String infokey;

    private String introduce;

    private String categoryId;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfourl() {
        return infourl;
    }

    public void setInfourl(String infourl) {
        this.infourl = infourl == null ? null : infourl.trim();
    }

    public String getInfokey() {
        return infokey;
    }

    public void setInfokey(String infokey) {
        this.infokey = infokey == null ? null : infokey.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }
}