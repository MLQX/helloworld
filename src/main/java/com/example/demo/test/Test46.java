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



public class Test46 {
    Student student = new Student();
    @Test
    public void testProxy(){
        Student proxy = ProxyUtil.proxy(student, new Aspect() {
            @Override
            public boolean before(Object target, Method method, Object[] args) {
                System.out.println("before");
                return false;
            }

            @Override
            public boolean after(Object target, Method method, Object[] args, Object returnVal) {
                System.out.println("after");
                return false;
            }

            @Override
            public boolean afterException(Object target, Method method, Object[] args, Throwable e) {
                System.out.println("afterException");
                return false;
            }
        });


        proxy.thorwExp();
        proxy.setName("hello");
    }
}
