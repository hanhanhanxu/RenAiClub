package cn.renai.service;

import cn.renai.mapper.EntranceyearMapper;
import cn.renai.pojo.Entranceyear;
import cn.renai.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntranceYearServiceImpl implements EntranceYearService {

    @Autowired
    private EntranceyearMapper entranceyearMapper;

    @Override
    public void addYear(Entranceyear entranceyear) {
        entranceyear.seteYId(WebUtils.generateID().substring(0,10));
        entranceyearMapper.insert(entranceyear);
    }

    @Override
    public List<Entranceyear> queryAll() {
        List<Entranceyear> list = entranceyearMapper.selectAll();
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void deleteYear(String eyid) {
        entranceyearMapper.deleteByPrimaryKey(eyid);
    }
}
