package cn.renai.mapper;

import cn.renai.pojo.Usersch;
import cn.renai.pojo.UserschExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserschMapper {
    int countByExample(UserschExample example);

    int deleteByExample(UserschExample example);

    int deleteByPrimaryKey(String uSc);

    int insert(Usersch record);

    int insertSelective(Usersch record);

    List<Usersch> selectByExample(UserschExample example);

    Usersch selectByPrimaryKey(String uSc);

    int updateByExampleSelective(@Param("record") Usersch record, @Param("example") UserschExample example);

    int updateByExample(@Param("record") Usersch record, @Param("example") UserschExample example);

    int updateByPrimaryKeySelective(Usersch record);

    int updateByPrimaryKey(Usersch record);

    int updateIsRenalByUid(String uid, Integer num);

    Usersch selectByUid(String uid);
}