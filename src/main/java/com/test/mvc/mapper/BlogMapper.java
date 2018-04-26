package com.test.mvc.mapper;

import com.test.mvc.domain.Blog;
import com.test.mvc.domain.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface BlogMapper {
    void addBlog(Blog blog);
    Blog get(int id);

    void delistByIds(@Param("ids") ArrayList<Integer> ids);

    void delistByArrayIds(@Param("ids") int[] ids);

    int blogInsertBatch(@Param("blogList") List<Blog> blogList);

    int blogUpdateBatch(@Param("blogList") List<Blog> blogList);
    List<Blog> blogSelectBatch(int size);
}
