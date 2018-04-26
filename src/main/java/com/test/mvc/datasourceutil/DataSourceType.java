package com.test.mvc.datasourceutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huangchangling on 2017/6/29 0029
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceType {

    Type value() default Type.DEFAULT;

     enum Type{

         DEFAULT,OTHER

     }
}
