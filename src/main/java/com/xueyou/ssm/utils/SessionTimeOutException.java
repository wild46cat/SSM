package com.xueyou.ssm.utils;

import org.springframework.stereotype.Component;

/**
 * Created by wuxueyou on 16/10/2.
 */
public class SessionTimeOutException extends Exception{
    public SessionTimeOutException(String message) {
        super(message);
    }
}
