package cn.renai.service;

import cn.renai.pojo.Programefield;

import java.util.List;

public interface ProgramefieldService {
    public List<Programefield> GetAllProCateField();
    //添加
    public void  AddProCateField(Programefield programefield);
    //修改
    public void UpdateProCateField(Programefield programefield);//只允许修改名称
    //删除
    public void DeleteProCateField(String ID);
}
