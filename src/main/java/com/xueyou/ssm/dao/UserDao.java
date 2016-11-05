package com.xueyou.ssm.dao;

import com.xueyou.ssm.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
public interface UserDao {
    public List<User> userList(Map<String ,Object> params);
    public int saveUser(User user);
    public int deleteUser(User user);
    public int updateUser(User user);
}
