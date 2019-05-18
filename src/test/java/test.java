import com.namimono.config.MyTypeFilter;
import com.namimono.config.Myconfig;
import com.namimono.entities.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class test {

    public void showBeans(ApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
    }
    @Test
    public void test1(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Myconfig.class);
        Person person= (Person) applicationContext.getBean("person");
        Person person2= (Person) applicationContext.getBean("person");
        System.out.println(person==person2);
    }

    @Test
    public void testCondition(){
//        aqua属于linux所以不会被注入到IOC中
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Myconfig.class);
        showBeans(applicationContext);
    }

}
