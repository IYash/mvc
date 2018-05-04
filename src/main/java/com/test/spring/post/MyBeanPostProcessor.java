package com.test.spring.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by huangchangling on 2018/5/4.
 * creating shared instance of singleton bean 'com.test.spring.post.MyBeanPostProcessor#0'
 * creating instance of bean 'com.test.spring.post.MyBeanPostProcessor#0'
 * eagerly caching bean 'com.test.spring.post.MyBeanPostProcessor#0' to allow for resolving potential circular reference
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof PostProcessorBean){
            System.out.println("PostProcessorBean Bean initializing");
            PostProcessorBean pb = (PostProcessorBean)bean;
            System.out.println("username:"+pb.getUsername());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //如果是PostProcessorBean则username信息
        if(bean instanceof PostProcessorBean){
            System.out.println("PostProcessorBean Bean initialized");
            PostProcessorBean pb = (PostProcessorBean)bean;
            System.out.println("username:"+pb.getUsername());
        }
        return bean;
    }
}
