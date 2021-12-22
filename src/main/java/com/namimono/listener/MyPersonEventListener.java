package com.namimono.listener;

import com.namimono.entities.Person;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class MyPersonEventListener implements ApplicationListener<PayloadApplicationEvent<Person>> {

    public void onApplicationEvent(PayloadApplicationEvent<Person> event) {
        System.out.println(event);
        Person payload = event.getPayload();
        System.out.println(payload);
    }
}
