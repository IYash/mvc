package com.test.spring.post;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by huangchangling on 2018/5/4.
 * bean 注册的流程分析:
 * ①pre-instantiating singleltons in DefaultListableBeanFactory:defining beans[postProcessorBean]
 * ②creating shared instance of singleton bean 'postProcessorBean'
 * ③creating instance of bean 'postProcessorBean'
 * ④执行构造器
 * ⑤eagerly caching bean 'postProcessorBean' to allow for resolving potential circular references
 * ⑥执行postProcessBeforeInitialization
 * ⑦执行afterPropertiesSet,init-method
 * ⑧执行postProcessAfterInitialization
 * ⑨finished creating instance of 'postProcessorBean'
 */
public class PostProcessorBean implements InitializingBean {
    private String username;
    private String password;

    public PostProcessorBean() {
        System.out.println("begin initialing---------------");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setUsername("changeAgain");
        System.out.println("afterPropertiesSet-------------");
    }
    public void init(){
        System.out.println("init-method run------------------");
    }
}
