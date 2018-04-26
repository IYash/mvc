package com.test.mvc.domain;


import gnu.trove.list.TLongList;
import gnu.trove.list.array.TLongArrayList;
import gnu.trove.map.hash.TLongIntHashMap;

import java.util.*;

/**
 * Created by Administrator on 2016/9/26.
 */
public class ThreadExpend implements Runnable{

    private String token="token";
    private int val1=1;
    private int val2=2;
    public static int TIMES=1000000;
    public static int capacity=100000;
    private static List<Long> arr;
    private static Map<Long,Integer> tMap;
    private static TLongIntHashMap tLongIntHashMap;
    private static TLongList tArr;
    static{
        initArrayList();
        initTraditionalMap();
        initTroveList();
        initTroveMap();
    }
    public static void initArrayList(){
        int i=0;
        arr=new ArrayList<Long>(capacity);
        while(i<TIMES){
            long val=13810100000l+i;
            arr.add(val);
            i++;
        }
    }
    public static void initTraditionalMap(){
        int i=0;
        tMap=new HashMap<Long, Integer>(capacity,0.75f);
        while(i<TIMES){
            long val=13810100000l+i;
            tMap.put(val, i);
            i++;
        }
    }
    public static void initTroveList(){
        int i=0;
        tArr=new TLongArrayList(capacity);
        while(i<TIMES){
            long val=13810100000l+i;
            tArr.add(val);
            i++;
        }

    }
    public static void initTroveMap(){
        int i=0;
        tLongIntHashMap=new TLongIntHashMap(capacity,0.75f);
        while(i<TIMES){
            long val=13810100000l+i;
            tLongIntHashMap.put(val, i);
            i++;
        }
    }
    public static void main(String[] args) {
        String info=new String("hello world");
       // System.out.println(Integer.MAX_VALUE+"================="+ Integer.SIZE);
        Thread td=new Thread(new ThreadExpend(),"local-1");
       td.start();
    }


        @Override public void run() {
            while(true){
                try {
            System.out.println("Be easy,don't worry..."+Thread.currentThread().getName()+"-------------------");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreadExpend that = (ThreadExpend) o;

        if (val1 != that.val1) return false;
        if (val2 != that.val2) return false;
        return token.equals(that.token);

    }

    @Override
    public int hashCode() {
        int result = token.hashCode();
        result = 31 * result + val1;
        result = 31 * result + val2;
        return result;
    }
}
