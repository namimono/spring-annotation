package com.namimono.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * //Build and validate a configuration model based on the registry of
 * processConfigBeanDefinitions()
 * 1.获取容器初始的所有bean 和 入口bean（配置类）
 *
 * 2.将所有实现了@Configuration注解的类信息（beanDefinition和beanName）保存在candidates中
 *
 * // Parse each @Configuration class
 * 3.创建解析类ConfigurationClassParser parser.parse(candidates)
 *      parse()方法接收外部提供的参数 configCandidates , 是一组需要被分析的候选配置类的集合，每个元素使用类型BeanDefinitionHolder包装 ;
 *      parse() 方法针对每个候选配置类元素BeanDefinitionHolder，执行以下逻辑 :
 *          1.将其封装成一个ConfigurationClass
 *          2.调用processConfigurationClass(ConfigurationClass configClass):
 *              processConfigurationClass（）中的doProcessConfigurationClass（）处理配置类:
 *                  1)一个配置类的成员类(配置类内嵌套定义的类)也可能适配类，先遍历这些成员配置类，调用processConfigurationClass处理它们;
 *                  2)处理配置类上的注解@PropertySources,@PropertySource
 *                  3)处理配置类上的注解@ComponentScans,@ComponentScan
 *                  4)处理配置类上的注解@Import
 *                  5)处理配置类上的注解@ImportResource
 *                  6)处理配置类中每个带有@Bean注解的方法
 *                  7)处理配置类所实现接口的缺省方法
 *                  8)检查父类是否需要处理，如果父类需要处理返回父类，否则返回null
 *
 */
@EnableTransactionManagement
@ComponentScan(value = "com.namimono",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class, Repository.class})
},useDefaultFilters = false)
@Configuration
public class MyconfigTx {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hx5847?useUnicode=true&characterEncoding=utf-8");
        return comboPooledDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {

        return new JdbcTemplate(dataSource());

    }
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {

        return new DataSourceTransactionManager(dataSource());
    }
}
