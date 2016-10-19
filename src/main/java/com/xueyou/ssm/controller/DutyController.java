package com.xueyou.ssm.controller;

import com.xueyou.ssm.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/17.
 */
@RestController
@RequestMapping(value = "/app",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8")
public class DutyController {
    @Autowired
    DutyService dutyService;

    @RequestMapping(value = "/dutylist")
    public Map<String,Object> dutyList(String depid){
        Map<String,Object> params = new HashMap<>();
        params.put("depid",depid);
        return dutyService.dutyList(params);
    }


    @RequestMapping(value = "/dutyadd")
    public Map<String,Object> dutyAdd(String depid,String dutyname,String memo,String orderNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("depid", depid);
        params.put("dutyname", dutyname);
        params.put("memo", memo);
        params.put("orderNumber", orderNumber);
        return dutyService.dutyAdd(params);
    }

    @RequestMapping(value = "/dutydelete")
    public Map<String,Object> dutyDelete(String dutyid) {
        Map<String, Object> params = new HashMap<>();
        params.put("dutyid", dutyid);
        return dutyService.dutyDelete(params);
    }

    @RequestMapping(value = "/dutyupdate")
    public Map<String,Object> dutyUpdate(String dutyid,String depid,String dutyname,String memo,String orderNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("dutyid", dutyid);
        params.put("depid", depid);
        params.put("dutyname", dutyname);
        params.put("memo", memo);
        params.put("orderNumber", orderNumber);
        return dutyService.dutyUpdate(params);
    }
}
