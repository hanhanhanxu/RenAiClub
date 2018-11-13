package cn.renai.mapper;

import cn.renai.pojo.Programefield;

import java.util.List;

public interface ProgramefieldMapper {
    List<Programefield> GetAllProCateField();
    //添加
    void  AddProCateField(Programefield programefield);
    //修改
    void UpdateProCateField(Programefield programefield);//只允许修改名称
    //删除
    void DeleteProCateField(String ID);
}
