package com.test.mvc.datasourceutil;

/**
 * @author huangchangling on 2017/6/28 0028
 */
public class DataSourceContextHolder {

    private static ThreadLocal<String> dataSourceNameHolder = new ThreadLocal<String>();

    public static String getDataSourceName(){

        return dataSourceNameHolder.get();

    }

    public static void setDataSourceName(String holder) {

        dataSourceNameHolder.set(holder);
    }

    public static void clear2Init(){

        dataSourceNameHolder.remove();
    }

}
