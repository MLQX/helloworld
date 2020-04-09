package com.example.demo.test;

import com.example.demo.pojo.Student;
import org.junit.Test;

import java.util.Objects;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 */


public class Test48 {
    @Test
    public void test1(){
        Student s = null;
        Objects.requireNonNull(s);
        Objects.isNull(s);
        System.out.println("heoo");


        //SecurityManager securityManager = System.getSecurityManager();
        //securityManager.checkExec("echo hello");
    }

}
