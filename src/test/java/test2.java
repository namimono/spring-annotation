import com.namimono.aop.Calculator;
import com.namimono.config.*;
import com.namimono.dao.PersonDao;
import com.namimono.entities.*;
import com.namimono.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;


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
/**
 *
 *  若要使用profile则要使用无参构造器AnnotationConfigApplicationContext()，并手动配置容器需要注册的配置文件，
 *  否则无法在容器启动之前配置相应的profile
 *  public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
 * 		this();
 * 		register(annotatedClasses);
 * 		refresh();
 *   }
 */
    @Test
    public void testProfile(){
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfigProfile.class);
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext();
//        先获取环境，然后设置Profile环境
        Environment environment = applicationContext.getEnvironment();
        ((ConfigurableEnvironment )environment) .setActiveProfiles("dev");
        ((AnnotationConfigApplicationContext) applicationContext).register(MyConfigProfile.class);
        ((AnnotationConfigApplicationContext) applicationContext).refresh();
        showBeans(applicationContext);

    }
    @Test
    public void testAdd1000k() throws SQLException {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        Environment environment = applicationContext.getEnvironment();
        ((ConfigurableEnvironment )environment) .setActiveProfiles("test");
        ((AnnotationConfigApplicationContext) applicationContext).register(MyConfigProfile.class);
        ((AnnotationConfigApplicationContext) applicationContext).refresh();
//        showBeans(applicationContext);
        for (int i=0;i<10000000;i++){
            Integer password = (int)(Math.random()*1000000);
            String nickname = getRandomString(5);
            JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
            String sql="insert into usersmessage (nickname, password,gender) values (?,?,?)";
            jdbcTemplate.update(sql,nickname,password+"","男");
        }
//        String substring = UUID.randomUUID().toString();
//        System.out.println(substring);
    }
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    @Test
    public void testAop(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfigAop.class);
        Calculator calculator = applicationContext.getBean(Calculator.class);
        showBeans(applicationContext);
        calculator.add(1,2);

    }
}
