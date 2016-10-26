package com.xueyou.ssm.service;

import java.util.Map;

/**
 * Created by wuxueyou on 16/9/29.
 */
public interface FirstService {
    public Map<String,Object> getJson(Map<String,Object> params);
    public Map<String,Object> insertUser(Map<String,Object> params);
}
