package com.xueyou.ssm.service;

import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
public interface UserService {
    public Map<String, Object> userList(Map<String, Object> params);
    public Map<String, Object> useradd(Map<String, Object> params);
    public Map<String, Object> userdel(Map<String, Object> params);
    public Map<String, Object> userupdate(Map<String, Object> params);
    public Map<String,Object> updatepwd(Map<String, Object> params);
}
