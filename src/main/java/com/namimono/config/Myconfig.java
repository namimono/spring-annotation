package com.namimono.config;

import com.namimono.entities.Person;
import com.namimono.service.PersonService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value ="com.namimono" ,includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class,Service.class} ),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
},useDefaultFilters = false)
public class Myconfig {

    @Scope(value = "prototype")
    @Bean
    public Person person(){

        return new Person(1,"aqua");
    }
}
