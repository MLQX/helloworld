package com.example.demo.test;


import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Dict数据结构
 */
@Slf4j
public class Test15 {

    public static void main(String[] args) {

        run1();
        //run2();
        //run5();

    }
    static void run1(){
        class T{
            int i;
            String f;
        }
        T t = new T();
        Map<String, Object> map = new HashMap<>();
        map.put("oo1", 1);
        map.put("oo2", 2);
        map.put("oo3", t);
        Dict dict = Dict.create()
                .set("key1", 1)
                .set("key2", map)
                .set("key3", 2);

        return;
    }




}




