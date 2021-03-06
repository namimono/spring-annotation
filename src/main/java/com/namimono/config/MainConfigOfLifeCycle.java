package com.namimono.config;

import com.namimono.entities.Dog;
import com.namimono.entities.User;
import org.springframework.context.annotation.*;


//类继承InitializingBean, DisposableBean接口，即可指定初始化方法和销毁方法
/**
 * bean的生命周期：
 * 		bean创建---初始化----销毁的过程
 * 容器管理bean的生命周期；
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 1.Construct(构造)（对象创建）:
 * 		单实例：在容器启动的时候创建对象
 * 		多实例：在每次获取的时候创建对象\
 *
 * 2.BeanPostProcessor.postProcessBeforeInitialization(前置处理器)
 *
 * 3.Initializing(初始化)：对象创建完成，并赋值好，调用初始化方法。。。
 *
 * 4.BeanPostProcessor.postProcessAfterInitialization(后置处理器)
 *
 * 5.Destroy(销毁)：
 * 		单实例：容器关闭的时候
 * 		多实例：容器不会管理这个bean；容器不会调用销毁方法；
 *
 *
 * 遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
 * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 *
 * BeanPostProcessor原理
 * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 * 在initializeBean方法中invokeInitMethods用来初始化bean，
 * 但是在invokeInitMethods之前和之后都有方法applyBeanPostProcessorsBeforeInitialization,applyBeanPostProcessorsAfterInitialization
 * initializeBean()
 * {
 *      applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *      invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
 *      applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 *
 *
 *
 * 1）、指定初始化和销毁方法；
 * 		通过@Bean指定init-method和destroy-method；
 * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
 * 				DisposableBean（定义销毁逻辑）;
 * 3）、可以使用JSR250；
 * 		@PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
 * 		@PreDestroy：在容器销毁bean之前通知我们进行清理工作
 * 4）、BeanPostProcessor【interface】：bean的后置处理器，需要专门创建一个后置处理器实现BeanPostProcessor接口
 * 		在所有bean初始化(initializting)前后进行一些处理工作；
 * 		postProcessBeforeInitialization:在初始化之前工作
 * 		postProcessAfterInitialization:在初始化之后工作
 *
 * Spring底层对 BeanPostProcessor 的使用；
 * 		bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor;
 *
 * @author lfy
 *
 */
@ComponentScan(value = "com.namimono",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = Myconfig.class)
})
@Configuration
@Import({User.class,Dog.class})
public class MainConfigOfLifeCycle {

//    @Bean
//    public User user(){
//        return new User();
//    }
}
