package com.namimono.listener;

import com.namimono.entities.Channel;
import com.namimono.entities.Person;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class MyChannelEventListener implements ApplicationListener<PayloadApplicationEvent<Channel>> {

    public void onApplicationEvent(PayloadApplicationEvent<Channel> event) {
        System.out.println(event);
        Channel payload = event.getPayload();
        System.out.println(payload);
    }
}
