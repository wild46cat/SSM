package com.xueyou.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/1.
 */
public interface LoginDao {
    public List<Map<String,Object>> login(Map<String,Object> params);
}
