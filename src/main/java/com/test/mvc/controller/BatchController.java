package com.test.mvc.controller;

import com.test.mvc.domain.Blog;
import com.test.mvc.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 * 批量插入和更新返回的数据测试
 */
@Controller
public class BatchController {
    @Autowired
    private IBlogService blogService;
    @RequestMapping("/insertBatch.do")
    @ResponseBody
    public void insertBatch(Model model){
        List<Blog> blogList = new ArrayList<>();
        int size = 200;
        for(int i=0;i<size;i++){
            Blog blog=new Blog("hello aspect",new Date());
            blogList.add(blog);
        }
       int ids = blogService.blogInsertBatch(blogList);
       System.out.println(ids);
    }
    @RequestMapping("/updateBatch.do")
    @ResponseBody
    public void updateBatch(Model model){
        List<Blog> blogList = blogService.blogSelectBatch(200);
        List<Blog> updateList = new ArrayList<>();
        int size = 200;
        for(int i=0;i<size;i++){
            Blog blog=blogList.get(i);
            blog.setMessage("update"+i);
            updateList.add(blog);
        }
        int ids = blogService.blogUpdateBatch(updateList);
        System.out.println(ids);
    }
}
