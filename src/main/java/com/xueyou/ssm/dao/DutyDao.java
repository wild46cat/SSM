package com.xueyou.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/17.
 */
public interface DutyDao {
    public List<Map<String,Object>> dutyList(Map<String,Object> params);
    public int dutyAdd(Map<String,Object> params);
    public int dutyDelete(Map<String,Object> params);
    public int dutyUpdate(Map<String,Object> params);
}
