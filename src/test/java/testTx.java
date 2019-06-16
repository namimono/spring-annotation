import com.namimono.config.*;
import com.namimono.entities.Employee;
import com.namimono.entities.User;
import com.namimono.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class testTx {

    @Test
    public void test1() throws InterruptedException {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyconfigTx.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaa");

    }
    @Test
    public void test2() throws InterruptedException {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyconfigTx.class);
        UserService userService = applicationContext.getBean(UserService.class);
        List<Employee> users = userService.getUser();
        System.out.println(users);

    }
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void testThread() throws ExecutionException, InterruptedException {
//        Future<Object> future = threadPoolTaskExecutor.submit(new Callable<Object>() {
//
//            public Object call() throws Exception {
//                for (int i = 0; i <10 ; i++) {
//                    System.out.println(i);
//                }
//                return "aa";
//            }
//        });
//
//        Object o = future.get();
//        System.out.println(o);
            threadPoolTaskExecutor.execute(new Runnable() {
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    System.out.println(i);
                }
            }
        });

    }
}
