package com.namimono.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.stereotype.Component;

@Component
public class MyAopAdvisor implements PointcutAdvisor {
    public Pointcut getPointcut() {
        return new SimplyPointcut();
    }

    public Advice getAdvice() {
        return new MyAopAdvice();
    }

    public boolean isPerInstance() {
        return false;
    }
}
