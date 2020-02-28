package com.example.demo.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
@Slf4j
public class Test31 {
    public static int a=6;
    public static int b=11;

    public static void main(String[] args) throws IOException {
        Test31 test31 = new Test31();
        Test31 test31Copy = new Test31();
        System.out.println(test31Copy.a);
        test31Copy.a=55;
        System.out.println(test31.a);


    }


    static void getSome(Object o){
        System.out.println("哈哈");
    }


}



