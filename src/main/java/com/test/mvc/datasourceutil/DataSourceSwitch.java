package com.test.mvc.datasourceutil;


import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


/**
 * @author huangchangling on 2017/6/29 0029
 */
public class DataSourceSwitch{

    private String DEFAULT_DATASOURCE = "defaultDataSource";
    private String OTHER_DATASOURCE ="otherDataSource";
    public void doSwitch(JoinPoint jp) throws Exception{

        Object target = jp.getTarget();
        String methodName=jp.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) jp.getSignature()).getMethod().getParameterTypes();
        Method method=target.getClass().getMethod(methodName,parameterTypes);
        DataSourceContextHolder.setDataSourceName(DEFAULT_DATASOURCE);
        boolean flag= method.isAnnotationPresent(DataSourceType.class);
        if(method != null && flag) {

            DataSourceType annotation = method.getAnnotation(DataSourceType.class);

            DataSourceType.Type type = annotation.value();

            if (DataSourceType.Type.OTHER == type) {

                    DataSourceContextHolder.setDataSourceName(OTHER_DATASOURCE);

            }
        }

    }
}
