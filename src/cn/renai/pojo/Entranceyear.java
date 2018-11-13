package cn.renai.pojo;

public class Entranceyear {
    private String eYId;

    private String year;

    public String geteYId() {
        return eYId;
    }

    public void seteYId(String eYId) {
        this.eYId = eYId == null ? null : eYId.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
}