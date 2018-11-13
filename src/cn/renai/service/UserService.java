package cn.renai.service;

import cn.renai.pojo.User;
import cn.renai.pojo.UserSecurity;
import cn.renai.pojo.Usersch;

import java.util.List;

public interface UserService {
    public User getUserById(String id);
    public User getUserByUsername(String username);

    public void addUserForRegist(User user);
    public boolean checkUsernameForRegist(String username);
    public User checkUserForLogin(User user);
    public void modifyPassword(User user);
    public void modifyUserInfo(User user);
    public void setSecurityQuestion(UserSecurity userSecurity);
    public UserSecurity checkUserSecurityByUid(String uid);

    public List getAllUser();
    public void joinRenai(String uid);
    public void removeRenai(String uid);
    public Usersch getUsersch(String uid);

    public void deleteUserByUid(String uid);
    public List queryUserByDouble(String username,String nickname);

    public void modifyUinfoByUser(User u,User user);
}
