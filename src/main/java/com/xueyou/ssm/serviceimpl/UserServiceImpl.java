package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.UserDao;
import com.xueyou.ssm.model.User;
import com.xueyou.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userdao;

    public Map<String, Object> userList(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        int page = (Integer.parseInt(params.get("page").toString()) - 1) * (Integer.parseInt(params.get("rows").toString()));
        params.put("page",page);
        resMap.put("total", userdao.userListCount(params).get(0).get("total").toString());
        resMap.put("rows", userdao.userList(params));
        return resMap;
    }

    public Map<String, Object> saveUser(User user) {
        Map<String ,Object> resMap = new HashMap<>();
        resMap.put("resCode",userdao.saveUser(user));
        return resMap;
    }

    public Map<String, Object> deleteUser(User user) {
        Map<String ,Object> resMap = new HashMap<>();
        resMap.put("resCode",userdao.deleteUser(user));
        return resMap;
    }

    public Map<String, Object> updateUser(User user) {
        Map<String ,Object> resMap = new HashMap<>();
        resMap.put("resCode",userdao.updateUser(user));
        return resMap;
    }

    public Map<String, Object> updateUserPhoto(User user) {
        Map<String ,Object> resMap = new HashMap<>();
        resMap.put("resCode",userdao.updateUserPhoto(user));
        return resMap;
    }
}
