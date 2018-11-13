package cn.renai.service;

import cn.renai.mapper.ProgrameMapper;
import cn.renai.pojo.Programe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrameServiceImpl implements ProgrameService {

    @Autowired
    private ProgrameMapper programeMapper;

    @Override
    public List<Programe> getall() {
        List<Programe> list = programeMapper.getall();
        return list;
    }

    @Override
    public void insertprocategory(Programe p) {
        programeMapper.insertprocategory(p);
    }

    @Override
    public List<Programe> ListProBySelect(String category, String field) {
        List<Programe> list = programeMapper.ListProBySelect(category,field);
        return list;
    }

    @Override
    public List<Programe> ListProBySelectCate(String category) {
        List<Programe> list = programeMapper.ListProBySelectCate(category);
        return list;
    }

    @Override
    public List<Programe> ListProBySelectField(String field) {
        List<Programe> list = programeMapper.ListProBySelectField(field);
        return list;
    }

    @Override
    public Programe SelectByid(String id) {
        Programe programe = programeMapper.SelectByid(id);
        return programe;
    }

    @Override
    public Boolean UpdateProcategory(Programe p) {
        return programeMapper.UpdateProcategory(p);
    }

    @Override
    public void DeleteProcategory(String ID) {
        programeMapper.DeleteProcategory(ID);
    }
}
