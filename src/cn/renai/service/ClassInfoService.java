package cn.renai.service;

import cn.renai.pojo.Classinfo;

import java.util.List;

public interface ClassInfoService {
    public void addClassInfo(Classinfo classinfo);
    public List<Classinfo> queryAll();
    public void deleteClassInfo(String clid);
}
