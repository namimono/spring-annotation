package com.namimono.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//@Aspect
public class LogAspect {
    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("@annotation(LogAopAnnotation)")
    public void pointCut(){};

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    @Before("@annotation(LogAopAnnotation)")
    public void logStart(JoinPoint joinPoint){
        System.out.println("before");
    }

    @After("@annotation(LogAopAnnotation)")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("after");
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value="@annotation(LogAopAnnotation)",returning="result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+result+"}");
    }

    @AfterThrowing(value="@annotation(LogAopAnnotation)",throwing="exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }

}
