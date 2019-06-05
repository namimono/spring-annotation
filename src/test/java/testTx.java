import com.namimono.config.*;
import com.namimono.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class testTx {

    @Test
    public void test1(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfigValue.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
//        UserService userService = applicationContext.getBean(UserService.class);
//        userService.insertUser("aqua","アイドル");

    }
}
