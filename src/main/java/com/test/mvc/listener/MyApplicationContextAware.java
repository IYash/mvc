package com.test.mvc.listener;

import com.test.mvc.domain.SysLog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

/**
 * @author huangchangling on 2017/6/20 0020
 */
public class MyApplicationContextAware implements FactoryBean<SysLog>,ApplicationContextAware,InitializingBean {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("get applicationContext =========== >>>>>>>>>>>>>>>>");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("yes");
    }

    @Override
    public SysLog getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
