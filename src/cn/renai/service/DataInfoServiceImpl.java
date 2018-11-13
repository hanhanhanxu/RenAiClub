package cn.renai.service;

import cn.renai.mapper.DatainfoMapper;
import cn.renai.pojo.Datainfo;
import cn.renai.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInfoServiceImpl implements DataInfoService {

    @Autowired
    private DatainfoMapper datainfoMapper;

    @Override
    public void addDataInfo(Datainfo datainfo) {
        datainfo.setDid(WebUtils.generateID().substring(0,10));
        datainfo.setDid(WebUtils.generateID().substring(0,10));
        datainfoMapper.insert(datainfo);
    }

    @Override
    public List queryAll() {
        List<Datainfo> list = datainfoMapper.queryAll();
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void deleteCategory(String datainfo_id) {
        datainfoMapper.deleteByPrimaryKey(datainfo_id);
    }

    @Override
    public List queryByCategory_id(String cid) {
        List list = datainfoMapper.queryByCategory_id(cid);
        if(list.isEmpty())
            return null;
        return list;
    }


}
