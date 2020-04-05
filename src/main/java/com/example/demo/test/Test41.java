package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 字符串
 */

@Slf4j
public class Test41 {


    public static void main(String[] args) {


        String a = "helloworld";
        String b = "helloworld";
        System.out.println(a==b);
        System.out.println(a.equals(b));
        String c = new String(a);
        String d = new String(a);
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(c == a);
        System.out.println(c.equals(a));


        System.out.println(a.hashCode());
        System.out.println("goge".hashCode() & 15);
        System.out.println("goge1".hashCode() & 15);
        System.out.println("goge2".hashCode() & 15);
        System.out.println("goge3".hashCode() & 15);
        System.out.println("goge4".hashCode() & 15);
        System.out.println(a.hashCode() & 15);
    }


}
