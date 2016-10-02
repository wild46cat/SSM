package com.xueyou.ssm.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wuxueyou on 16/10/2.
 */
@Aspect
//@Component("SessionTimeOutAspect")
public aspect SessionTimeOutAspect {
    private static Logger logger = Logger.getLogger(SessionTimeOutAspect.class);

    /*@Pointcut("execution(* com.xueyou.ssm.controller.*.*(..))")
    public void ControllerPointcut(){}

    @Pointcut("execution(* com.xueyou.ssm.controller.LoginController.ssmLogin(..))")
    public void PublicContentPointcut(){}

    @Pointcut("ControllerPointcut() && (!PublicContentPointcut())")
    public void SessionTimeOutPointcut(){}

    @Before("ControllerPointcut()")
    public Object sessionTimeOutAdvice(ProceedingJoinPoint pjp) throws IOException {
        Object result = null;
        String targetName = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        logger.info("----------------执行方法-----------------");
        logger.info("类名："+targetName+" 方法名："+methodName);
        HttpServletResponse response = null;
        for (Object param : pjp.getArgs()) {
            if (param instanceof HttpServletResponse) {
                response = (HttpServletResponse) param;
            }
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        if(session.getAttribute("username")!=null){
            try {
                result = pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        } else{
            logger.debug("Session已超时，正在跳转回登录页面");
            response.sendRedirect(request.getContextPath());
        }
        return result;
    }*/
}
