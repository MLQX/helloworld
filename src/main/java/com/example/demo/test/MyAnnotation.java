package com.example.demo.test;

import java.lang.annotation.*;


//运行期注解,反射才能取得到
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface MyAnnotation {



}
