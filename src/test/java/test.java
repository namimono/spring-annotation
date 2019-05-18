import com.namimono.config.Myconfig;
import com.namimono.entities.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Myconfig.class);
        Person person= (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Myconfig.class);
        String[] beans=applicationContext.getBeanDefinitionNames();
        for(String name:beans){
            System.out.println(name);
        }
    }

}
