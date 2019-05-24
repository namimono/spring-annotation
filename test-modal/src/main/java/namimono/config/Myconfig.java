package namimono.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//ComponentScan针对类进行过滤，condition针对实例化的对象进行过滤
@Configuration
@ComponentScan(value ="namimono.config" ,includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Component.class} ),
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
},useDefaultFilters = false)
//import可以直接导入多个类加入到IOC中，省去了用@bean一个个导入
public class Myconfig {

}
