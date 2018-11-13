package cn.renai.mapper;

import cn.renai.pojo.User;
import cn.renai.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);

    User selectByUsernameAndPassword(User user);

    int updateInFoByPrimaryKey(User user);

    int updatePasswordByPrimaryKey(User user);

    List selectAll();

    List selectByUsernameAndNickname(String username,String nickname);

    List selectByUsernameOrNickname(String username,String nickname);
}