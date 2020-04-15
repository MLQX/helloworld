package com.example.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型通配符
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 */


public class Test51 {
    @Test
    public void test1(){
        List<String> li = new ArrayList<>();
        //run(li); // List<Object>接口不是List<String>接口的父类
        List<Object> li2 = new ArrayList<>();
        run(li2);
        run2(li);

    }

    public void run(List<Object> arg) {
        for (int i = 0; i < arg.size(); i++) {
            System.out.println(arg.get(i));
        }
    }
    public void run2(List<?> arg) {
        for (int i = 0; i < arg.size(); i++) {
            System.out.println(arg.get(i));
        }
    }


}
