package cn.renai.service;

import cn.renai.mapper.ModularMapper;
import cn.renai.pojo.Modular;
import cn.renai.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModularServiceImpl implements ModularService {
    @Autowired
    private ModularMapper modularMapper;

    @Override
    public Modular QueryByMid(String mid) {
        return modularMapper.selectByPrimaryKey(mid);
    }

    @Override
    public List queryAll() {
        List<Modular> list = modularMapper.queryAll();
        if (list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void addModular(Modular modular) {
        modular.setMid(WebUtils.generateID().substring(0,10));
        modularMapper.insert(modular);
    }

    @Override
    public void deleteModular(String modular_id) {
        modularMapper.deleteByPrimaryKey(modular_id);
    }
}
