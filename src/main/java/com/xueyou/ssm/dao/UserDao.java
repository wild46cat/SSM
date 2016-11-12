package com.xueyou.ssm.dao;

import com.xueyou.ssm.model.User;
import com.xueyou.ssm.model.User2;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
public interface UserDao {
    public List<User> userList(Map<String ,Object> params);
    public List<Map<String,Object>> userListCount(Map<String,Object> params);
    public int saveUser(User user);
    public int deleteUser(User user);
    public int updateUser(User user);
    public int updateUserPhoto(User user);

    public List<User2> user2List(Map<String,Object> params);

}
