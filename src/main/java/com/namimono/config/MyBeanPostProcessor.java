package com.namimono.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
//如果BeanPostProcessor被加入到IOC容器中，所有Bean初始化时都会用到
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(s+":postProcessBeforeInitialization");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(s+":postProcessAfterInitialization");
        return o;
    }
}
