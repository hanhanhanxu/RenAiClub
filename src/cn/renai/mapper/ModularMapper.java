package cn.renai.mapper;

import cn.renai.pojo.Modular;
import cn.renai.pojo.ModularExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModularMapper {
    int countByExample(ModularExample example);

    int deleteByExample(ModularExample example);

    int deleteByPrimaryKey(String mid);

    int insert(Modular record);

    int insertSelective(Modular record);

    List<Modular> selectByExample(ModularExample example);

    Modular selectByPrimaryKey(String mid);

    int updateByExampleSelective(@Param("record") Modular record, @Param("example") ModularExample example);

    int updateByExample(@Param("record") Modular record, @Param("example") ModularExample example);

    int updateByPrimaryKeySelective(Modular record);

    int updateByPrimaryKey(Modular record);

    List<Modular> queryAll();
}