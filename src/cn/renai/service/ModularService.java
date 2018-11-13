package cn.renai.service;

import cn.renai.pojo.Modular;

import javax.xml.ws.Service;
import java.util.List;

public interface ModularService {
    public Modular QueryByMid(String mid);
    public List queryAll();
    public void addModular(Modular modular);
    public void deleteModular(String modular_id);
}
