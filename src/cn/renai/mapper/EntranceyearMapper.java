package cn.renai.mapper;

import cn.renai.pojo.Entranceyear;
import cn.renai.pojo.EntranceyearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntranceyearMapper {
    int countByExample(EntranceyearExample example);

    int deleteByExample(EntranceyearExample example);

    int deleteByPrimaryKey(String eYId);

    int insert(Entranceyear record);

    int insertSelective(Entranceyear record);

    List<Entranceyear> selectByExample(EntranceyearExample example);

    Entranceyear selectByPrimaryKey(String eYId);

    int updateByExampleSelective(@Param("record") Entranceyear record, @Param("example") EntranceyearExample example);

    int updateByExample(@Param("record") Entranceyear record, @Param("example") EntranceyearExample example);

    int updateByPrimaryKeySelective(Entranceyear record);

    int updateByPrimaryKey(Entranceyear record);

    List<Entranceyear> selectAll();
}