package com.test.mvc.multithd;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */

public class Processor implements Runnable {

    private String processName;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("wait...");
                Thread.sleep(1*60*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public class sayHello implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    System.out.println("hello...");
                    Thread.sleep(1*6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class sayHi implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    System.out.println("hi...");
                    Thread.sleep(1*6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class MsgContent{
        String content;

        public MsgContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "MsgContent{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }
    public static class PropertyTest {
        String content;
        String name;
        MsgContent msgContent;

        public MsgContent getMsgContent() {
            return msgContent;
        }

        public void setMsgContent(MsgContent msgContent) {
            this.msgContent = msgContent;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "PropertyTest{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        /**
         * 指向同一引用的数据修改
         */
        MsgContent content = new MsgContent("init===");
        PropertyTest p1=new PropertyTest();
        PropertyTest p2=new PropertyTest();
        PropertyTest p3=new PropertyTest();
        PropertyTest p4=new PropertyTest();
        p1.setMsgContent(content);
        p2.setMsgContent(content);
        p3.setMsgContent(content);
        p4.setMsgContent(content);
        List<PropertyTest> list = new ArrayList<PropertyTest>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        for (PropertyTest p:list
             ) {
            System.out.println(p.getMsgContent());
            String c=null;
            c=content.getContent()+"+123";
            p.getMsgContent().setContent(c);
            System.out.println(p.getMsgContent());
            System.out.println("===========================");
        }
    }
}

