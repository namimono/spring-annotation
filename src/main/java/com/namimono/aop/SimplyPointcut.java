package com.namimono.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * 自定义切入点
 */
@Component
public class SimplyPointcut extends StaticMethodMatcherPointcut {
    public boolean matches(Method method, Class<?> targetClass) {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof LogAopAnnotation) {
                return true;
            }
        }
        return false;
    }
}
