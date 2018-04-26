package com.test.mvc.domain;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/6.
 */
public class AjaxResult implements Serializable{
    private String msg;
    private boolean flag=true;
    public AjaxResult(){}
    public AjaxResult(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String toJsonString(){
       return  JSONObject.toJSONString(this);
    }
}
