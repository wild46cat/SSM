package com.xueyou.ssm.dao;

import com.xueyou.ssm.model.Ttee;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/9/29.
 */
public interface FirstDao {
    public List<Map<String, Object>> getUser(Map<String, Object> params);
    public int insertUser(Map<String, Object> params);
    public int inserttestTable(Ttee ttee);
}
