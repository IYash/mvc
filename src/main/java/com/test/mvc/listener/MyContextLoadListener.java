package com.test.mvc.listener;

import com.test.mvc.domain.Blog;
import com.test.mvc.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by Administrator on 2016/9/8.
 */
public class MyContextLoadListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        System.out.println(event.getServletContext().getRealPath("")+"hello world");
    }
}
