package com.test.mvc.domain;

import com.test.mvc.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huangchangling on 2018/9/12.
 */
public class Monitor {
    @Autowired
    private IBlogService iBlogService;
    public String monitor(String str) {
        iBlogService.getClass();
        return " be easy! ";
    }

}
