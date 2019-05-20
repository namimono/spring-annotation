package com.namimono.entities;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class User implements InitializingBean, DisposableBean {
    public User() {
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("User----Desstroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("User----initializing");

    }
}
