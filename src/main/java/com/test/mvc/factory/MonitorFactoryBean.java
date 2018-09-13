package com.test.mvc.factory;

import com.test.mvc.domain.Monitor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by huangchangling on 2018/9/12.
 * 通过自定义FactoryBean实现自定义bean的注入
 * 通过实现InitializingBean初始化monitor
 */
//@Component
public class MonitorFactoryBean implements FactoryBean<Monitor>,InitializingBean,DisposableBean {

    private Monitor monitor;

    @Override
    public Monitor getObject() throws Exception {
        return this.monitor;
    }

    @Override
    public Class<?> getObjectType() {
        return Monitor.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.monitor = new Monitor();
    }
}
