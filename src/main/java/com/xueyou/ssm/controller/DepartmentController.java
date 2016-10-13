package com.xueyou.ssm.controller;

import com.xueyou.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wuxueyou on 16/10/12.
 */
@RestController
@RequestMapping(value = "/app",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8;")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/departmentlist")
    public Map<String,Object> departmentList(){
        return departmentService.departmentList();
    }
}
