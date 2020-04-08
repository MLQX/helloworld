//package com.example.demo.test;
//
//
//import com.example.demo.hutool.core.convert.Convert;
//import com.example.demo.hutool.core.lang.Console;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Date;
//import java.util.List;
//
//
//@Slf4j
//public class Test10 {
//
//    public static void main(String[] args) {
//
//
//        int a = 1;
//        String ret = Convert.toStr(a);
//        Console.log(ret instanceof String);
//        long[] b = {1, 2, 3, 5};
//        String ret2 = Convert.toStr(b);
//        Console.log(ret2 instanceof String);
//
//        String[] c = {"1", "2", "3"};
//        Integer[] d =Convert.toIntArray(c);
//        Console.log(d);
//
//        //时间转换
//        String e = "2017-06-16";
//        Date f = Convert.toDate(e);
//        Console.log(f);
//
//        //数组->集合
//        Object[] g = {"a", "Ni", "嚎"};
//        List<?> li = Convert.toList(g);
//        Console.log(li);
//
//    }
//
//}
//
//
//
//
