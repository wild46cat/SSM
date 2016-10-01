package com.xueyou.ssm.controller;

import com.xueyou.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/1.
 */
@RestController
@RequestMapping(value = "/login" , method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8;")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/ssmlogin")
    public Map<String,Object> ssmLogin(String username,String password){
        Map<String,Object> params = new HashMap<>();
        System.out.println(username);
        System.out.println(password);
        params.put("username",username);
        params.put("password",password);
        return loginService.login(params);
    }
}
