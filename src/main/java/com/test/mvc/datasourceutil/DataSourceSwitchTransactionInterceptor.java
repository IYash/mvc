package com.test.mvc.datasourceutil;

import org.aopalliance.intercept.MethodInvocation;

import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.lang.reflect.Method;

/**
 * @author huangchangling on 2017/6/29 0029
 */
public class DataSourceSwitchTransactionInterceptor extends TransactionInterceptor {

    //private String DEFAULT_DATASOURCE = "defaultDataSource";
    private String OTHER_DATASOURCE ="otherDataSource";

    public Object invoke(MethodInvocation invocation) throws Throwable {

        Method method = invocation.getMethod();

        DataSourceContextHolder.clear2Init();

        if( method != null && method.isAnnotationPresent(DataSourceType.class)){

            DataSourceType annotation = method.getAnnotation(DataSourceType.class);

            String typeStr = annotation.value().name();

            if (typeStr == DataSourceType.Type.OTHER.name()) {
                DataSourceContextHolder.setDataSourceName(OTHER_DATASOURCE);
            }
        }

        return super.invoke(invocation);
    }
}
