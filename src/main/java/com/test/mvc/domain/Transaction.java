package com.test.mvc.domain;

/**
 * Created by Administrator on 2016/10/26.
 */
public class Transaction {
    private int id;
    private int msgType;

    public Transaction() {
    }

    public Transaction(int msgType) {
        this.msgType = msgType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }
}
