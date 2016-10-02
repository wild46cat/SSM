package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.LoginDao;
import com.xueyou.ssm.service.LoginService;
import com.xueyou.ssm.utils.Base;
import com.xueyou.ssm.utils.SysContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
            resMap.put("resCode", Base.MSG_CODE_ERROR);
            resMap.put("resMsg",Base.MSG_USERNAMEORPASSWORDWRONG);
        }else {
            HttpSession session = SysContent.getSession();
            session.setAttribute("username",params.get("username").toString());
            session.setAttribute("password",params.get("password").toString());
            resMap.put("resCode",Base.MSG_CODE_SUCCESS);
            resMap.put("resMsg",Base.MSG_SUCCESS);
        }
        return resMap;
    }
}
