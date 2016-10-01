package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.LoginDao;
import com.xueyou.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/1.
 */
@Service("LoginService")
public class LoginServiceimpl implements LoginService{
    @Autowired
    LoginDao loginDao;

    @Override
    public Map<String, Object> login(Map<String, Object> params) {
        Map<String,Object> resMap = new HashMap<>();
        List<Map<String,Object>> tempUserList = loginDao.login(params);
        if(tempUserList.size() == 0){
            resMap.put("resCode","0");
            resMap.put("resMsg","user name or password wrong!");
        }else {
            resMap.put("resCode","1");
            resMap.put("resMsg","login success!");
        }
        return resMap;
    }
}
