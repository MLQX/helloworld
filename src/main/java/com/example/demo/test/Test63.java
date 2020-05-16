package com.example.demo.test;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/5 22:36
 *
 *  CollUtil
 */
@Slf4j
public class Test63 {


    @Before
    public void before() {

    }

    @Test
    public void test1() {
        //相当于集合并集操作
        ArrayList<Integer> integers = CollUtil.newArrayList(1, 2, 3);
        ArrayList<Integer> integers1 = CollUtil.newArrayList(1, 2, 5);
        List<Integer> integers2 = CollUtil.addAllIfNotContains(integers, integers1);
        System.out.println(integers2);

        //Map<String, List<Object>> map = new HashMap<String,List<Object>>() {
        //    private static final long serialVersionUID = -7972341714171418145L;
        //
        //    {
        //        put("1", new ArrayList<>());
        //    }
        //};
        //Map<String, List<Object>> map = new HashMap<String, List<Object>>();
        //map.put("hello", new ArrayList<>());
        //Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();
        //map.put("hello", new ArrayList<>());

        //List<T> ts = CollUtil.addAllIfNotContains(map, map2);


        String key = "key1,key2,key3,key4";
        String value = "value1,value2,value3,value4";
        Map<String, String> zip = CollUtil.zip(key, value,"&");
        System.out.println(zip);


    }
}
