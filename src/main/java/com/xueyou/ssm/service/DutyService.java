package com.xueyou.ssm.service;

import java.util.Map;

/**
 * Created by wuxueyou on 16/10/17.
 */
public interface DutyService {
    public Map<String,Object> dutyList(Map<String,Object> params);
    public Map<String,Object> dutyAdd(Map<String,Object> params);
    public Map<String,Object> dutyDelete(Map<String,Object> params);
    public Map<String,Object> dutyUpdate(Map<String,Object> params);
}
