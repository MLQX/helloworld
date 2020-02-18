package com.example.demo.test;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.bean.copier.ValueProvider;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Slf4j
public class Test18{
    static void run2(){

        Set<Object> set = new HashSet<>();
        set.add("a");
        set.add("b");

        String[] strs = {"xx", "yy", "zz"};
        set.add(strs);


        List<Object> list = new ArrayList<>(set);  //? extends xx
        list.forEach(System.out::println);
    }



    public static void main(String[] args) {
        run2();

    }


}


//TODO: 测试数组的class类型和基本元素的class类型区别


