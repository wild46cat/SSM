package com.xueyou.ssm.aspect;


import com.xueyou.ssm.utils.Base;
import com.xueyou.ssm.utils.SessionTimeOutException;
import com.xueyou.ssm.utils.SysContent;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/1.
 */
@Aspect
@Component("TestAspect")
public class TestAspect {
    private static Logger logger = Logger.getLogger(TestAspect.class);

    //    @Around("execution(* com.xueyou.ssm.controller.*.*(..)) " +
//            "and !execution(* com.xueyou.ssm.controller.LoginController.ssmLogin(..)) " +
//            "and !execution(* com.xueyou.ssm.controller.UrlPageController.*(..))")
    @Around("@annotation(com.xueyou.ssm.annotation.ControllerAnnotationLogin)")
    public Object sessionTimeOutAdvice(ProceedingJoinPoint pjp) throws SessionTimeOutException{
        Object args[] = pjp.getArgs();
        Object result = null;
        String targetName = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        logger.info("----------------执行方法-----------------");
        logger.info("类名：" + targetName + " 方法名：" + methodName);

        HttpSession session = SysContent.getSession();
        if (session.getAttribute("username") != null) {
            try {
                result = pjp.proceed(args);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        } else {
//            System.out.println(((MethodSignature)pjp.getSignature()).getReturnType().getSimpleName().toString());
            String redirectStr = "login";
            String returnType = ((MethodSignature)pjp.getSignature()).getReturnType().getSimpleName().toString();
            if(returnType.equals("String")){
                return redirectStr;
            }else if(returnType.equals("Map")){
                Map<String,Object> resMap = new HashMap<>();
                resMap.put("resCode", Base.MSG_CODE_SESSIONOUTOFDATE);
                resMap.put("resMsg",Base.MSG_SESSIONOUTOFDATE);
                return resMap;
            }else {
                throw new SessionTimeOutException(Base.MSG_SESSIONOUTOFDATE);
            }
        }
    }
}
