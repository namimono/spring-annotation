package com.namimono.config;

import com.namimono.dao.PersonDao;
import com.namimono.entities.Animal;
import com.namimono.entities.Cat;
import com.namimono.entities.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * @Autowired ：
 *      优先按照类型匹配IOC容器中的bean，如果找到相同类型的bean则按照名字来匹配。
 *      @Qualifier("personDao2")
 *      @Autowired
 *      private PersonDao personDao;
 *     可强行指定要用哪一个bean装配
 */

@ComponentScan(value = {"com.namimono"},includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class, Repository.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Animal.class, Cat.class})
},useDefaultFilters = false)
@Configuration
public class MyconfigAutowired{

//    @Bean("personDao2")
//    public PersonDao personDao(){
//        PersonDao personDao = new PersonDao();
//        personDao.setLabel("2");
//        return personDao;
//    }
}
