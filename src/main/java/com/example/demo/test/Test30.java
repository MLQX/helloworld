package com.example.demo.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 关于::运算符
 * 这个运算符应该是一种机制,可以抽象方法,只要有对应的函数式接口.
 *
 */
@Slf4j
public class Test30 {


    public static void main(String[] args) throws IOException {


        IPrint iPrint = Something::printHello;
        iPrint.doPrint();

        Something s = new Something();
        IPrint iPrint1 = s::printHay;
        iPrint1.doPrint();

        IPrint iPrint2 = Something::new;
        iPrint2.doPrint();

        //IPrint iPrint3 = Something::printHello2;

    }


    static class Something {
        public Something(){
            System.out.println("构造");
        }

        static void printHello() {
            System.out.println("hello");
        }


        static void printHello2(String msg) {
            System.out.println("hello2");
        }

        void printHay() {
            System.out.println("hay");
        }
    }


}


@FunctionalInterface
interface IPrint {
    void doPrint();
}

