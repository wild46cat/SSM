package com.xueyou.ssm.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wuxueyou on 16/10/1.
 */
@Aspect
@Component("TestAspect")
public class TestAspect {
    @Before("execution(* com.xueyou.ssm.serviceimpl.*.*(..))")
    public void authority(){
        System.out.println("this is my first spring aop");
    }
}
