package cn.renai.service;

import cn.renai.pojo.Entranceyear;

import java.util.List;

public interface EntranceYearService {
    public void addYear(Entranceyear entranceyear);
    public List<Entranceyear> queryAll();
    public void deleteYear(String eyid);
}
