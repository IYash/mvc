package com.test.mvc.contextAware;

import com.test.mvc.controller.BaseController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huangchangling on 2017/6/26 0026
 */
@Repository
public class PermissionSystemAware implements ApplicationContextAware,InitializingBean{


    private ApplicationContext act;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.act = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String[] cs = act.getBeanDefinitionNames();

        for (String clz:cs
             ) {
           //从容器中获取对应的bean
            //Class.forName(clz);获取字节码
            Object obj = act.getBean(clz);

            if (obj instanceof BaseController) {

                System.out.println(" class name is: "+obj.getClass().getSimpleName()+" ==========");

            }
        }
    }
}
