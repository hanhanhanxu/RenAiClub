package cn.renai.service;

import cn.renai.pojo.Programecategory;

import java.util.List;

public interface ProgramecategoryService {
    public List<Programecategory> GetAllProCate();
    //添加
    public void  AddProCate(Programecategory programecategory);
    //修改
    public void UpdateProCate(Programecategory programecategory);//只允许修改名称
    //删除
    public void DeleteProCate(String ID);
}
