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
}
