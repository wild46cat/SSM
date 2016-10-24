package com.xueyou.ssm.controller;

import com.xueyou.ssm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wuxueyou on 16/10/24.
 */
@RestController
@RequestMapping(value = "/app",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8;")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/getmenulist")
    public Map<String,Object> getMenuList(){
        return menuService.getMenuList();
    }

}
