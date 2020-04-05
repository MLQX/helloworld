package com.example.demo.test;

import cn.hutool.core.io.FileUtil;
import com.example.demo.pojo.User;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 集合框架
 */

@Slf4j
public class Test40 {


    public static void main(String[] args) {


        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a3532", "a");
        linkedHashMap.put("age3b", "b");
        linkedHashMap.put("cg3eac", "c");
        linkedHashMap.put("325dc", "d");
        linkedHashMap.put("e2523", "e");
        linkedHashMap.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s+"---"+s2);
            }
        });



        Map<String, String> map = new HashMap<>();
        map.put("a3532", "a");
        map.put("age3b", "b");
        map.put("cg3eac", "c");
        map.put("325dc", "d");
        map.put("e2523", "e");
        map.forEach((s, s2) -> System.out.println(s+"---"+s2));


        List<String> list = new ArrayList<>();
        list.add("goe4");
        list.add("goe42t");
        list.add("goe42tget");
        Object[] objects = list.toArray();
        //接受的参数为一个接口， 这个接口 in: ? super String, out: void
        Arrays.stream(objects).forEach(new Consumer<Object>() {
            @Override
            public void accept(Object s) {
                System.out.println(s);
            }
        });
        // s->System.out.println(s)  ->  System.out::println
        //Arrays.stream(objects).forEach(System.out::println);
        Test40 test40 = new Test40();
        Arrays.stream(objects).forEach(test40::code);

        System.out.println("goe42tget的哈希码为: "+"goe42tget".hashCode());


    }
    public void code(Object o){
        System.out.println("哈希码为："+o.hashCode());
    }


}
