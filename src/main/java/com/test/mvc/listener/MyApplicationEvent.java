package com.test.mvc.listener;


import com.test.mvc.domain.Blog;
import com.test.mvc.domain.Blog;
import com.test.mvc.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/8.
 */
@Component
public class MyApplicationEvent implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private BlogMapper blogMapper;

    private int flag=0;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("contextRefreshedEvent----------------------");
        if(flag==0){
        blogMapper.addBlog(new Blog("init",new Date()));
        flag=1;
        }
    }
}
