package com.example.demo.test;

import java.util.HashMap;
import java.util.Objects;

public class Test37 {


    public static void main(String[] args) {

        String hello = "hello";
        int i = Objects.hashCode(hello);
        System.out.println("hashcode is： "+i);

        System.out.println(hello.hashCode());




    }
}
