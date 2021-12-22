package com.namimono.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 自定义通知
 */
public class MyAopAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        System.out.println("=========================this is MyAopAdvice==========================");
        return invocation.proceed();
    }
}
