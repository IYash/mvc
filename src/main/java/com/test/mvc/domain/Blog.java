package com.test.mvc.domain;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/25.
 */
@Alias("Blog")
public class Blog {
    private int id;
    private String message;
    private Date createTime;
    public Blog() {
    }

    public Blog(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Blog(String message, Date createTime) {
        this.message = message;
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
