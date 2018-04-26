package com.test.mvc.domain;




import com.test.mvc.service.ISysLogService;

import org.aspectj.lang.JoinPoint;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/5.
 */
@Component
@Aspect
public class SystemLogService {
    @Autowired
    private ISysLogService sysLogService;

    private static final String EXPRESSION="execution(* com.test.mvc.controller..*(..))";
    public void log(){
        //System.out.println(jp);
        System.out.println("========================");
    }
    @Before(EXPRESSION)
    public void before(JoinPoint jp) throws NoSuchMethodException {
        Object target=jp.getTarget();
        String methodName=jp.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) jp.getSignature()).getMethod().getParameterTypes();
        Method method=target.getClass().getMethod(methodName,parameterTypes);
        if(method!=null && method.isAnnotationPresent(com.test.mvc.annotation.SysLog.class)){
           com.test.mvc.annotation.SysLog annotation=method.getAnnotation(com.test.mvc.annotation.SysLog.class);
            Date opTime=new Date();
            String className=target.getClass().getName();
            String[] infos=annotation.operateArea();
            String opArea=infos[0];
            String opController =infos[1];
            String opAction=infos[2];
            com.test.mvc.domain.SysLog sysLog=new com.test.mvc.domain.SysLog("usr",opTime,opArea,opController,opAction);
            sysLogService.addSysLog(sysLog);
            System.out.println(sysLog.getId()+" ---> get keyProperty");
        }
    }
}
