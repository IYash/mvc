package com.test.mvc.controller;

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
    @RequestMapping("/css.do")
    public void index(HttpServletResponse response) throws IOException {
       response.sendRedirect("index.jsp");
    }
}
