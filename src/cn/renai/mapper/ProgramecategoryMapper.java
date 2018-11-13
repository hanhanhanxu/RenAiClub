package cn.renai.mapper;

import cn.renai.pojo.Programecategory;

import java.util.List;

public interface ProgramecategoryMapper {
    List<Programecategory> GetAllProCate();
    //添加
    void  AddProCate(Programecategory programecategory);
    //修改
    void UpdateProCate(Programecategory programecategory);//只允许修改名称
    //删除
    void DeleteProCate(String ID);

}
