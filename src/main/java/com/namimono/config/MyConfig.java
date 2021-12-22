package com.namimono.config;

import com.namimono.entities.Person;
import com.namimono.listener.ExecutorMulticaster;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

//ComponentScan针对类进行过滤，condition针对实例化的对象进行过滤
@Configuration
@ComponentScan(value = "com.namimono",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Component.class})},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Configuration.class})},
        useDefaultFilters = false)
public class MyConfig {
    @Bean
    public Person aqua() {
        return new Person(1, "aqua");
    }

    @Bean
    public Person mea() {
        return new Person(1, "mea");
    }

    @Bean
    public Person shion() {
        return new Person(1, "shion");
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("UTF-8");
        source.addBasenames("messageSource");
        return source;
    }

//    @Bean("applicationEventMulticaster")
    public SimpleApplicationEventMulticaster executorMulticaster() {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(Executors.newCachedThreadPool());
        return multicaster;
    }
}
