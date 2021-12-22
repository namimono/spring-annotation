package com.namimono.listener;

import com.namimono.entities.Channel;
import com.namimono.entities.Person;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher implements ApplicationEventPublisherAware {
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new Person(1, "mea"));
        applicationEventPublisher.publishEvent(new Channel("http://mea"));
    }
}
