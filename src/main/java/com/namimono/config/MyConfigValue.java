package com.namimono.config;

import com.namimono.entities.Person;
import org.springframework.context.annotation.*;

//使用@PropertySource()可以读取配置文件。
@PropertySource(value = {"classpath:/config/person.properties"})
@Configuration
public class MyConfigValue {

    @Bean
    public Person person(){
        return new Person();
    }
}
