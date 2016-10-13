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
        resMap.put("count", userdao.userCount().get(0).get("count"));
        return resMap;
    }

    public Map<String, Object> useradd(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        List<Map<String, Object>> isExistList = userdao.getIsExist(params);
        if (isExistList.size() != 0) {
            resMap.put("resCode", "9999");
        } else {
            resMap.put("resCode", userdao.useradd(params));
        }
        return resMap;
    }

    public Map<String, Object> userdel(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("resCode", userdao.userdel(params));
        return resMap;
    }

    public Map<String, Object> userupdate(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("resCode", userdao.userupdate(params));
        return resMap;
    }

    public Map<String,Object> updatepwd(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        List<Map<String, Object>> isExistList = userdao.oldPasswordSuccess(params);
        if (isExistList.size() == 0) {
            resMap.put("msg","oldPasswordWrong");
        } else {
            if(userdao.updatePassword(params) > 0){
                resMap.put("msg","success");
            }else{
                resMap.put("msg","updateFail");
            }
        }
        return resMap;
    }
}
