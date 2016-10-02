package com.xueyou.ssm.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wuxueyou on 16/10/2.
 */
@Component("MyExceptionHandler")
public class MyExceptionHandler extends SimpleMappingExceptionResolver {
    private Logger logger = Logger.getLogger(MyExceptionHandler.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return getModelAndView("error", ex);
    }
}
