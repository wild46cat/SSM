package com.xueyou.ssm.controller;

import com.xueyou.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/11.
 */
@RestController
@RequestMapping(value = "/user",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userlist")
    public Map<String, Object> userList(String pageNum,String pageSize) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);
        return userService.userList(params);
    }

    @RequestMapping(value = "/useradd")
    public Map<String, Object> useradd(String policeid,String pwd,String policenum,String policename,String sex,String status,String email,String tel,String birthday,String summary,String dutyid,String photo) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("policeid",policeid);
        params.put("pwd",pwd);
        params.put("policenum",policenum);
        params.put("policename",policename);
        params.put("sex",sex);
        params.put("status",status);
        params.put("email",email);
        params.put("tel",tel);
        params.put("birthday",birthday);
        params.put("summary",summary);
        params.put("dutyid",dutyid);
        params.put("photo",photo);
        return userService.useradd(params);
    }

    @RequestMapping(value = "/userdel")
    public Map<String, Object> userdel(String policeid){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("policeid",policeid);
        return userService.userdel(params);
    }

    @RequestMapping(value = "/userupdate")
    public Map<String, Object> userupdate(String policeid,String pwd,String policenum,String policename,String sex,String status,String email,String tel,String birthday,String summary,String dutyid,String photo) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("policeid",policeid);
        params.put("pwd",pwd);
        params.put("policenum",policenum);
        params.put("policename",policename);
        params.put("sex",sex);
        params.put("status",status);
        params.put("email",email);
        params.put("tel",tel);
        params.put("birthday",birthday);
        params.put("summary",summary);
        params.put("dutyid",dutyid);
        params.put("photo",photo);
        return userService.userupdate(params);
    }

    @RequestMapping(value = "/updatepwd")
    public Map<String,Object> updatepwd(String policeid,String password,String newpassword,HttpServletRequest request){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("policeid",policeid);
        params.put("password",password);
        params.put("newpassword",newpassword);
        Map<String,Object> resMap = userService.updatepwd(params);
        if(resMap.get("msg").toString().equals("success")){
            request.getSession().setAttribute("pwd",newpassword);
        }
        return resMap;

    }

}
