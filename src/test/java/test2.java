import com.namimono.config.MyConfigValue;
import com.namimono.config.Myconfig;
import com.namimono.config.MyconfigAutowired;
import com.namimono.dao.PersonDao;
import com.namimono.entities.Animal;
import com.namimono.entities.Cat;
import com.namimono.entities.Person;
import com.namimono.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class test2 {
    public void showBeans(ApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
    }
    @Test
    public void test1(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfigValue.class);
        showBeans(applicationContext);
        Object person = applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testAutowired(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyconfigAutowired.class);
        PersonService bean = applicationContext.getBean(PersonService.class);
        System.out.println(bean);
//        PersonDao personDao= applicationContext.getBean(PersonDao.class);
//        System.out.println(personDao);

    }
    @Test
    public void testAutowired2(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyconfigAutowired.class);
        showBeans(applicationContext);
        System.out.println(applicationContext);

    }
}
