package com.xueyou.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
public interface UserDao {
    public List<Map<String ,Object>> userList(Map<String ,Object> params);
    public List<Map<String ,Object>> userCount();
    public List<Map<String ,Object>> getIsExist(Map<String ,Object> params);
    public List<Map<String ,Object>> oldPasswordSuccess(Map<String ,Object> params);
    public int useradd(Map<String ,Object> params);
    public int userdel(Map<String ,Object> params);
    public int userupdate(Map<String ,Object> params);
    public int updatePassword(Map<String ,Object> params);
}
