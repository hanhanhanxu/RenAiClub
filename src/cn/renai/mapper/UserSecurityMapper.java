package cn.renai.mapper;

import cn.renai.pojo.UserSecurity;
import cn.renai.pojo.UserSecurityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSecurityMapper {
    int countByExample(UserSecurityExample example);

    int deleteByExample(UserSecurityExample example);

    int deleteByPrimaryKey(String uIId);

    int insert(UserSecurity record);

    int insertSelective(UserSecurity record);

    List<UserSecurity> selectByExample(UserSecurityExample example);

    UserSecurity selectByPrimaryKey(String uIId);

    int updateByExampleSelective(@Param("record") UserSecurity record, @Param("example") UserSecurityExample example);

    int updateByExample(@Param("record") UserSecurity record, @Param("example") UserSecurityExample example);

    int updateByPrimaryKeySelective(UserSecurity record);

    int updateByPrimaryKey(UserSecurity record);

    UserSecurity selectByUid(String uid);

    int updateByUserid(UserSecurity userSecurity);
}