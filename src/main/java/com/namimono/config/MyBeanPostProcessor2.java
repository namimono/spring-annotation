package com.namimono.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//如果BeanPostProcessor被加入到IOC容器中，所有Bean初始化时都会用到
@Component
public class MyBeanPostProcessor2 implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(s+":postProcessBeforeInitialization2");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(s+":postProcessAfterInitialization2");
        return o;
    }
}
