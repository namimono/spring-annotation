package com.namimono.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;

public class ExecutorMulticaster implements ApplicationEventMulticaster {
    public void addApplicationListener(ApplicationListener<?> listener) {

    }

    public void addApplicationListenerBean(String listenerBeanName) {

    }

    public void removeApplicationListener(ApplicationListener<?> listener) {

    }

    public void removeApplicationListenerBean(String listenerBeanName) {

    }

    public void removeAllListeners() {

    }

    public void multicastEvent(ApplicationEvent event) {

    }

    public void multicastEvent(ApplicationEvent event, ResolvableType eventType) {

    }
}
