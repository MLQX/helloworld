package com.example.demo.hutool.core.annotation;

import java.lang.annotation.*;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 17:15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
public @interface Alias {



    /**
     * 别名值，即使用此注解要替换成的别名名称
     *
     * @return 别名值
     */
    String value();



}
