package cn.renai.service;

import cn.renai.pojo.Datainfo;
import cn.renai.pojo.Modular;

import java.util.List;

public interface DataInfoService {
    public void addDataInfo(Datainfo datainfo);
    public List queryAll();
    public void deleteCategory(String datainfo_id);

    public List queryByCategory_id(String cid);
}
