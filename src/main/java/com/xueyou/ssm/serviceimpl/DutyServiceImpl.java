package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.DutyDao;
import com.xueyou.ssm.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/17.
 */
@Service("DutyService")
public class DutyServiceImpl implements DutyService{
    @Autowired
    DutyDao dutyDao;

    public Map<String, Object> dutyList(Map<String, Object> params) {
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("list",dutyDao.dutyList(params));
        return resMap;
    }

    public Map<String, Object> dutyAdd(Map<String, Object> params) {
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("resCode",dutyDao.dutyAdd(params));
        return resMap;
    }

    public Map<String, Object> dutyDelete(Map<String, Object> params) {
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("resCode",dutyDao.dutyDelete(params));
        return resMap;
    }

    public Map<String, Object> dutyUpdate(Map<String, Object> params) {
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("resCode",dutyDao.dutyUpdate(params));
        return resMap;
    }
}
