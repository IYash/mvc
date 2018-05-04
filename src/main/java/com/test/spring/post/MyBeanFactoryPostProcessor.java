package com.test.spring.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by huangchangling on 2018/5/4.
 * Creating shared instance of singleton bean 'com.test.spring.post.MyBeanFactoryPostProcessor#0'
 * Creating instance of bean 'com.test.spring.post.MyBeanFactoryPostProcessor#0'
 * Eagerly caching bean 'com.test.spring.post.MyBeanFactoryPostProcessor#0' to allow for resolving potential circular references
 * Finished creating instance of bean 'com.test.spring.post.MyBeanFactoryPostProcessor#0'
 * postProcessBeanFactory works=================
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //BeanFactoryPostProcessor可以修改BEAN的配置信息而BeanPostProcessor不能
        //我们在这里修改postProcessorBean的username注入属性
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("postProcessorBean");
        MutablePropertyValues pv = bd.getPropertyValues();
        System.out.println("postProcessBeanFactory works=================");
        if(pv.contains("username"))
            pv.addPropertyValue("username","xiaojun");
    }
}
