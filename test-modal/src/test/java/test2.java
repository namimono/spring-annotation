import namimono.config.Myconfig;
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
    public void testAutowired2(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Myconfig.class);
        showBeans(applicationContext);
    }
}
