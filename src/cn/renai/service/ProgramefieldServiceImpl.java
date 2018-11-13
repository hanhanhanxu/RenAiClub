package cn.renai.service;

import cn.renai.mapper.ProgramefieldMapper;
import cn.renai.pojo.Programefield;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramefieldServiceImpl implements ProgramefieldService{

    @Autowired
    private ProgramefieldMapper programefieldMapper;

    @Override
    public List<Programefield> GetAllProCateField() {
        List<Programefield> list =  programefieldMapper.GetAllProCateField();
        return list;
    }

    @Override
    public void AddProCateField(Programefield programefield) {
        programefieldMapper.AddProCateField(programefield);
    }

    @Override
    public void UpdateProCateField(Programefield programefield) {
        programefieldMapper.UpdateProCateField(programefield);
    }

    @Override
    public void DeleteProCateField(String ID) {
        programefieldMapper.DeleteProCateField(ID);
    }
}
