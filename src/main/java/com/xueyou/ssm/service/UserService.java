package com.xueyou.ssm.service;

import com.xueyou.ssm.model.User;

import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
public interface UserService {
    public Map<String, Object> userList(Map<String, Object> params);
    public Map<String, Object> saveUser(User user);
    public Map<String, Object> deleteUser(User user);
    public Map<String, Object> updateUser(User user);
}
