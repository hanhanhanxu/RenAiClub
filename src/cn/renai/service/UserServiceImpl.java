package cn.renai.service;

import cn.renai.mapper.UserMapper;
import cn.renai.mapper.UserSecurityMapper;
import cn.renai.mapper.UserschMapper;
import cn.renai.pojo.User;
import cn.renai.pojo.UserSecurity;
import cn.renai.pojo.Usersch;
import cn.renai.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserSecurityMapper userSecurityMapper;
    @Autowired
    private UserschMapper userschMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void addUserForRegist(User user) {
        user.setUid(WebUtils.generateID().substring(0,15));
        user.setAdmin(0);
        user.setPassword(WebUtils.md5(user.getPassword()));
        if (user.getTel()==null ){
            user.setTel("");
        }
        if (user.getQq()==null){
            user.setQq("");
        }
        if (user.getClassid()==null){
            user.setClassid("");
        }
        if (user.getEntrance()==null){
            user.setEntrance("");
        }
        if (user.getIntroduce()==null){
            user.setIntroduce("");
        }
        userMapper.insert(user);

        Usersch usersch = new Usersch();
        usersch.setuSc(WebUtils.generateID());
        usersch.setuId(user.getUid());
        usersch.setIsrenai(0);
        usersch.setScha(0);
        usersch.setSchb(0);
        usersch.setSchc(0);
        usersch.setSchd(0);
        usersch.setSche(0);
        userschMapper.insert(usersch);//USERSCH 约束表中插入信息
    }

    @Override
    public boolean checkUsernameForRegist(String username) {
        if(userMapper.selectByUsername(username)==null)
            return true;
        return false;
    }

    @Override
    public User checkUserForLogin(User user) {
        user.setPassword(WebUtils.md5(user.getPassword()));
        return userMapper.selectByUsernameAndPassword(user);
    }

    @Override
    public void modifyPassword(User user) {
        user.setPassword(WebUtils.md5(user.getPassword()));//加密
        userMapper.updatePasswordByPrimaryKey(user);
    }

    @Override
    public void modifyUserInfo(User user) {
        userMapper.updateInFoByPrimaryKey(user);
    }

    @Override
    public void setSecurityQuestion(UserSecurity userSecurity) {
        if(userSecurityMapper.selectByUid(userSecurity.getUserId())==null){//表中无此记录
            userSecurity.setuIId(WebUtils.generateID().substring(0,10));
            userSecurityMapper.insertSelective(userSecurity);
        }else{
            userSecurityMapper.updateByUserid(userSecurity);
        }
    }

    @Override
    public UserSecurity checkUserSecurityByUid(String uid) {
        return userSecurityMapper.selectByUid(uid);
    }

    @Override
    public List getAllUser() {
        List list = userMapper.selectAll();
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void joinRenai(String uid) {
        userschMapper.updateIsRenalByUid(uid,1);
    }

    @Override
    public void removeRenai(String uid) {
        userschMapper.updateIsRenalByUid(uid,0);
    }

    @Override
    public Usersch getUsersch(String uid) {
        Usersch usersch = userschMapper.selectByUid(uid);
        if(usersch==null){
            usersch = new Usersch();
            usersch.setuId(uid);
            usersch.setIsrenai(0);
            usersch.setScha(0);
            usersch.setSchb(0);
            usersch.setSchc(0);
            usersch.setSchd(0);
            usersch.setSche(0);
        }
        return usersch;
    }

    @Override
    public void deleteUserByUid(String uid) {
        userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public List queryUserByDouble(String username, String nickname) {
        List list;
        if(username.length()!=0 && nickname.length()!=0){//username和nickname都存在值
            list = userMapper.selectByUsernameAndNickname(username,nickname);
        }else if(username.length()==0 && nickname.length()==0){//都不存在值 ，，搜索全部
            list = userMapper.selectAll();
        }else{
            list = userMapper.selectByUsernameOrNickname(username,nickname);
        }
        if(list.isEmpty())
            return null;
        return list;
    }

    @Override
    public void modifyUinfoByUser(User u, User user) {
        u.setNickname(user.getNickname());
        //u.setUsername(user.getUsername());
        u.setTel(user.getTel());
        u.setQq(user.getQq());
        u.setIntroduce(user.getIntroduce());
       userMapper.updateInFoByPrimaryKey(u);
    }
}
