package cn.renai.service;

import cn.renai.pojo.Programe;

import java.util.List;

public interface ProgrameService {
    public List<Programe> getall();
    public void insertprocategory(Programe p);
    //检索
    public List<Programe> ListProBySelect(String category, String field);
    //检索 2
    public List<Programe> ListProBySelectCate(String category);
    //检索 3
    public List<Programe> ListProBySelectField(String field);
    //详情
    public Programe SelectByid(String id);
    //修改
    Boolean UpdateProcategory(Programe p);
    //删除
    void DeleteProcategory(String ID);

}
