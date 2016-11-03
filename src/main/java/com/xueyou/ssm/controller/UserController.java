package com.xueyou.ssm.controller;

import com.xueyou.ssm.model.User;
import com.xueyou.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
@RestController
@RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userlist")
    public Map<String, Object> userList(String pageNum, String pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("pageNum",pageNum);
//        params.put("pageSize",pageSize);
        return userService.userList(params);
    }

    @RequestMapping(value = "/testjson")
    public Map<String, Object> testjson() {
        User u = new User();
        u.setBirthday("2016-11-03 22:15:33");
        u.setName("xxx");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("user", u);
        return resMap;
    }

    @RequestMapping(value = "/saveUser")
    public Map<String, Object> saveUser(User user) {
        Map<String,Object> params = new HashMap<>();
        params.put("user",user);
        System.out.println("===============");
        System.out.println(user.getStatus());
        System.out.println("===============");
        return userService.saveUser(user);
    }
}
