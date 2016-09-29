package com.xueyou.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/9/29.
 */
public interface FirstDao {
    public List<Map<String, Object>> getUser(Map<String, Object> params);
}
