package com.xueyou.ssm.controller;

import com.xueyou.ssm.annotation.ControllerAnnotationLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wuxueyou on 16/10/1.
 */
@Controller
@RequestMapping(value = "/web", method = {RequestMethod.GET, RequestMethod.POST})
public class UrlPageController {
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @ControllerAnnotationLogin
    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }

    @ControllerAnnotationLogin
    @RequestMapping(value = "/usermanagement")
    public String userManagement(){
        return "systemManagement/user";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "welcome";
    }

    @ControllerAnnotationLogin
    @RequestMapping(value = "/common/fileupload")
    public String fileUpload(){
        return "/common/fileupload";
    }

    @ControllerAnnotationLogin
    @RequestMapping(value = "/departmentmanagement")
    public String departmentManagement(){
        return "systemManagement/department";
    }
}
