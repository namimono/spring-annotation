package com.namimono.config;

import com.namimono.condition.LinuxCondition;
import com.namimono.entities.Person;
import com.namimono.service.PersonService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//ComponentScan针对类进行过滤，condition针对实例化的对象进行过滤
@Configuration
@ComponentScan(value ="com.namimono" ,includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class,Service.class, Repository.class} ),
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
},useDefaultFilters = false)
//import可以直接导入多个类加入到IOC中，省去了用@bean一个个导入
@Import(value = {MyImportSelector.class})
public class Myconfig {
    /**
     *  singleton：默认，单实例，ioc容器启动时就会创建所有对象到ioc容器中
     *  prototype: 多实例，用到对象时，才会将对象创建并加入ioc容器
     *
     * @return
     */
//    @Lazy  懒加载 用于scope=singleton
//    @Scope(value = "prototype")
    @Conditional({LinuxCondition.class})
    @Bean
    public Person aqua(){
        return new Person(1,"aqua");
    }
    @Bean
    public Person mea(){
        return new Person(1,"mea");
    }
    @Bean
    public Person shion(){
        return new Person(1,"shion");
    }
}
