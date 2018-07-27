package com.test.support;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by huangchangling on 2018/7/27.
 */
public class DBNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("db",new DBBeanDefinitionParser());
    }
}
