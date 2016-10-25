package com.xueyou.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.xueyou.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/12.
 */
@RestController
@RequestMapping(value = "/app", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8;")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/departmentlist")
    public Map<String, Object> departmentList() {
        return departmentService.departmentList();
    }

    @RequestMapping(value = "/departmentadd")
    public Map<String, Object> departmentAdd(String nodename, String parentid, String memo, String order) {
        Map<String, Object> params = new HashMap<>();
        params.put("nodename", nodename);
        params.put("parentid", parentid);
        params.put("memo", memo);
        params.put("order", order);
        return departmentService.departmentAdd(params);
    }

    @RequestMapping(value = "/departmentedit")
    public Map<String, Object> departmentEdit(String nodeid, String nodename, String parentid, String memo, String order) {
        Map<String, Object> params = new HashMap<>();
        params.put("nodeid", nodeid);
        params.put("nodename", nodename);
        params.put("parentid", parentid);
        params.put("memo", memo);
        params.put("order", order);
        return departmentService.departmentEdit(params);
    }

    @RequestMapping(value = "/departmentdelete")
    public Map<String, Object> departmentDelete(String depid) {
        Map<String, Object> params = new HashMap<>();
        params.put("depid", depid);
        return departmentService.departmentDelete(params);
    }

    @RequestMapping(value = "/departmentdeletecascade")
    public Map<String, Object> departmentDeleteCascade(String depid) {
        Map<String, Object> params = new HashMap<>();
        params.put("depid",depid);
        return departmentService.departmentDeleteCascade(params);
    }

    @RequestMapping(value = "/departmentnewroot")
    public Map<String, Object> departmentnewroot() {
        return departmentService.departmentNewRoot();
    }

}
