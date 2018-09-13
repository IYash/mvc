package com.test.mvc.service;

import com.test.mvc.datasourceutil.DataSourceType;
import com.test.mvc.domain.Blog;
import com.test.mvc.domain.Blog;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public interface IBlogService {

    @DataSourceType(DataSourceType.Type.OTHER)
    @Transactional(propagation = Propagation.NEVER)
    void addBlog(Blog blog);

    void delistByIds(ArrayList<Integer> ids);

    void delistByArrayIds(int[] ids);

    int blogInsertBatch(List<Blog> blogList);

    int blogUpdateBatch(List<Blog> blogList);

    List<Blog> blogSelectBatch(int size);

}
