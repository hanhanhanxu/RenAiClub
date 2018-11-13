package cn.renai.mapper;

import cn.renai.pojo.Programe;

import java.util.List;

public interface ProgrameMapper {
    List<Programe> getall();
    void insertprocategory(Programe p);
    //修改
    Boolean UpdateProcategory(Programe p);
    //删除
    void DeleteProcategory(String ID);
    //检索 1
    List<Programe> ListProBySelect(String category, String field);
    //检索 2
    List<Programe> ListProBySelectCate(String category);
    //检索 3
    List<Programe> ListProBySelectField(String field);
    //详情
    Programe SelectByid(String id);
}
