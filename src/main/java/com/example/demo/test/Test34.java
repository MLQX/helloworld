package com.example.demo.test;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * 简单ThreadLocal
 */
@Slf4j
public class Test34 {
    ////set 方法
    //public void set(T value) {
    //    //获取当前线程
    //    Thread t = Thread.currentThread();
    //    //实际存储的数据结构类型
    //    ThreadLocalMap map = getMap(t);
    //    //如果存在map就直接set，没有则创建map并set
    //    if (map != null)
    //        map.set(this, value);
    //    else
    //        createMap(t, value);
    //}
    //
    ////getMap方法
    //ThreadLocalMap getMap(Thread t) {
    //    //thred中维护了一个ThreadLocalMap
    //    return t.threadLocals;
    //}
    //
    ////createMap
    //void createMap(Thread t, T firstValue) {
    //    //实例化一个新的ThreadLocalMap，并赋值给线程的成员变量threadLocals
    //    t.threadLocals = new ThreadLocalMap(this, firstValue);
    //}


    static ThreadLocal<String> lovalVar = new ThreadLocal<>();

    static void print(String str){
        System.out.println(str+" :"+lovalVar.get());
        lovalVar.remove();
    }




    public static void main(String[] args) throws IOException {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lovalVar.set("localVar1");
                print("thread1");
                System.out.println("after remove: " + lovalVar.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lovalVar.set("localVar2");

                print("thread2");
                System.out.println("after remove: " + lovalVar.get());
            }
        });

        t1.start();
        t2.start();


    }





}



