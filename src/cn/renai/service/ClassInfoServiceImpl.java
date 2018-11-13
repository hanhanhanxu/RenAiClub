package cn.renai.service;

import cn.renai.mapper.ClassinfoMapper;
import cn.renai.pojo.Classinfo;
import cn.renai.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassinfoMapper classinfoMapper;

    @Override
    public void addClassInfo(Classinfo classinfo) {
        classinfo.setcIId(WebUtils.generateID().substring(0,10));
        classinfoMapper.insert(classinfo);
    }

    @Override
    public List<Classinfo> queryAll() {
        List<Classinfo> list = classinfoMapper.selectAll();
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void deleteClassInfo(String clid) {
        classinfoMapper.deleteByPrimaryKey(clid);
    }
}
