package cn.renai.mapper;

import cn.renai.pojo.Datainfo;
import cn.renai.pojo.DatainfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatainfoMapper {
    int countByExample(DatainfoExample example);

    int deleteByExample(DatainfoExample example);

    int deleteByPrimaryKey(String did);

    int insert(Datainfo record);

    int insertSelective(Datainfo record);

    List<Datainfo> selectByExample(DatainfoExample example);

    Datainfo selectByPrimaryKey(String did);

    int updateByExampleSelective(@Param("record") Datainfo record, @Param("example") DatainfoExample example);

    int updateByExample(@Param("record") Datainfo record, @Param("example") DatainfoExample example);

    int updateByPrimaryKeySelective(Datainfo record);

    int updateByPrimaryKey(Datainfo record);

    List<Datainfo> queryAll();

    List<Datainfo> queryByCategory_id(String cid);
}