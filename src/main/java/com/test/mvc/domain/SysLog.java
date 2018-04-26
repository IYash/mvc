package com.test.mvc.domain;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SysLog {
    private long id;
    private String operator;
    private Date opTime;
    private String opArea;
    private String opController;
    private String opAction;

    public SysLog() {
    }

    public SysLog(String operator, Date opTime, String opArea, String opController, String opAction) {
        this.operator = operator;
        this.opTime = opTime;
        this.opArea = opArea;
        this.opController = opController;
        this.opAction = opAction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getOpArea() {
        return opArea;
    }

    public void setOpArea(String opArea) {
        this.opArea = opArea;
    }

    public String getOpController() {
        return opController;
    }

    public void setOpController(String opController) {
        this.opController = opController;
    }

    public String getOpAction() {
        return opAction;
    }

    public void setOpAction(String opAction) {
        this.opAction = opAction;
    }
}
