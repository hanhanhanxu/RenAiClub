package cn.renai.service;

import cn.renai.mapper.ProgramecategoryMapper;
import cn.renai.pojo.Programecategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramecategoryServiceImpl implements ProgramecategoryService {

    @Autowired
    private ProgramecategoryMapper programecategoryMapper;

    @Override
    public List<Programecategory> GetAllProCate() {
        List<Programecategory> list = programecategoryMapper.GetAllProCate();
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void AddProCate(Programecategory programecategory) {
        programecategoryMapper.AddProCate(programecategory);
    }

    @Override
    public void UpdateProCate(Programecategory programecategory) {
        programecategoryMapper.UpdateProCate(programecategory);
    }

    @Override
    public void DeleteProCate(String ID) {
        programecategoryMapper.DeleteProCate(ID);
    }
}
