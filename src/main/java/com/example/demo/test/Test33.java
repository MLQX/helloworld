package com.example.demo.test;


import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/**
 *
 */
@Slf4j
public class Test33 {
    public static int a=6;
    public static int b=11;

    public static void main(String[] args) throws IOException {


        Map<String, Object> map = new TreeMap<>();
        map.put("1", 3);
        map.put("3", 1);
        map.put("2", 2);

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("11", 3);
        map2.put("33", 1);
        map2.put("22", 2);
        map.forEach(new BiConsumer<String, Object>() {
            @Override
            public void accept(String s, Object o) {
                System.out.println(o);
            }
        });

        map2.forEach(new BiConsumer<String, Object>() {
            @Override
            public void accept(String s, Object o) {
                System.out.println(o);
            }
        });



    }





}



