package com.test.mvc.controller;

import com.test.mvc.domain.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangchangling on 2018/8/14.
 */
@Controller
public class StyleController {
    @Autowired
    private Monitor monitor;
    @RequestMapping("/css.do")
    public void index(HttpServletResponse response) throws IOException {
        System.out.println(monitor.monitor("css")+"-----------------------------------");
       response.sendRedirect("index.jsp");
    }
}
