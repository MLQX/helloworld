//package com.example.demo.test;
//
//import com.example.demo.hutool.core.lang.Console;
//import com.example.demo.hutool.core.lang.Snowflake;
//import com.example.demo.hutool.core.util.ArrayUtil;
//import com.example.demo.hutool.core.util.IdUtil;
//import com.example.demo.hutool.core.util.NumberUtil;
//import com.example.demo.hutool.core.util.RandomUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//
//
//@Slf4j
//public class Test5 {
//
//    public static void main(String[] args) {
//
//
//        //IdUtil
//        // randomUUID方法和simpleUUID方法
//        String a = IdUtil.randomUUID();
//        Console.log(a);
//        String b = IdUtil.simpleUUID();
//        Console.log(b);
//
//
//        //ObjectId
//        String c= IdUtil.objectId();
//        Console.log(c);
//
//        //雪花ID ,分布式系统
//        //参数1为终端ID
//        //参数2为数据中心ID
//        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
//        long id = snowflake.nextId();
//        Console.log(id);
//
//
//
//
//    }
//
//}
//
//
//
//
