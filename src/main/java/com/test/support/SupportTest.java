package com.test.support;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huangchangling on 2018/7/27.
 */
public class SupportTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:applicationContext_support.xml");
        DBConfig dbConfig = ctx.getBean(DBConfig.class);
        System.out.println(dbConfig.getUrl());
        System.out.println(dbConfig.getUsername());
        System.out.println(dbConfig.getPassword());

    }
}
