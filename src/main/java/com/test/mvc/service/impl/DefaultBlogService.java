package com.test.mvc.service.impl;

import com.test.mvc.domain.Blog;
import com.test.mvc.mapper.BlogMapper;
import com.test.mvc.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
@Service
public class DefaultBlogService implements IBlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Override
    @Transactional
    public void addBlog(Blog blog) {
        blogMapper.addBlog(blog);
    }

    @Override
    public void delistByIds(ArrayList<Integer> ids) {
        blogMapper.delistByIds(ids);
    }

    @Override
    public void delistByArrayIds(int[] ids) {
        blogMapper.delistByArrayIds(ids);
    }

    @Override
    public int blogInsertBatch(List<Blog> blogList) {
        int result = blogMapper.blogInsertBatch(blogList);
        //int ex = 1/0;//用于验证spring service层的事务机制，事务回滚，但是表id自增了
        return result;
    }

    @Override
    public int blogUpdateBatch(List<Blog> blogList) {
        return blogMapper.blogUpdateBatch(blogList);
    }

    @Override
    public List<Blog> blogSelectBatch(int size) {
        return blogMapper.blogSelectBatch(size);
    }
}
