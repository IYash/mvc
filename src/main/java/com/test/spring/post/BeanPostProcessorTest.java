package com.test.spring.post;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huangchangling on 2018/5/4.
 */
public class BeanPostProcessorTest {

    private static String path = "classpath*:applicationContext_test.xml";
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
       PostProcessorBean bean = (PostProcessorBean)ctx.getBean("postProcessorBean");
        System.out.println("-----------testBeanFactoryPostProcessor-----------");
       System.out.println("username:"+bean.getUsername());
        System.out.println("password:"+bean.getPassword());
    }

}
