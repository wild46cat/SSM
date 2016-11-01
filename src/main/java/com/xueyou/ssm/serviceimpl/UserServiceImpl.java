package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.UserDao;
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
        resMap.put("list", userdao.userList(params));
        return resMap;
    }


}
