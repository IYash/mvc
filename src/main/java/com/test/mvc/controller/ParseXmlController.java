package com.test.mvc.controller;

import com.test.mvc.domain.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huangchangling on 2017/7/27 0027
 */


@Controller
public class ParseXmlController extends BaseController {


    @RequestMapping("/xmlParse.do")
    @ResponseBody
    public AjaxResult xmlParser(Model model, HttpServletRequest request){

        AjaxResult result = new AjaxResult("OK");

        String xmlBody = request.getParameter("<?xml version");


        System.out.println(xmlBody);

        return result;
    }
}
