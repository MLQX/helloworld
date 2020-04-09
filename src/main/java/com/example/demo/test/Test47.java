package com.example.demo.test;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.Aspect;
import com.example.demo.pojo.Student;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 */


public class Test47 {
    @Test
    public void throwExcep(){

        try {

            throw new RuntimeException("wrong");
        } catch (Exception ex) {
            System.out.println("ee");

        }finally {
            System.out.println("finally");
        }
        System.out.println("end");


    }

}
