package com.namimono.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TestResourceLoadAware implements ResourceLoaderAware, BeanDefinitionRegistryPostProcessor {

    private ScannedGenericBeanDefinition beanDefinition;

    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource = resourceLoader.getResource("classpath:com/namimono/entities/Person.class");
        try {
            MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(resource);
            beanDefinition = new ScannedGenericBeanDefinition(metadataReader);
            beanDefinition.setSource(resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("aaaaaaaaa");
    }

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        registry.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
        System.out.println("====================执行自定义beanRegistry==================");
        FileSystemResource fileSystemResource = new FileSystemResource("C:\\Users\\nakami\\Documents\\IdeaProjects\\spring-annotation\\target\\classes\\com\\namimono\\entities\\Person.class");

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
