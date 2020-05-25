package com.example.demo.test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/26 00:11
 *
 *  ThreadLocal
 */
@Slf4j
public class Test66 {


    @Before
    public void before() {

    }

    @Test
    public void test1() {



    }





    public static void main(String[] args) {
        class TestDemo{

            private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            public void doSomething() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i < 100; i++) {
                                threadLocal.set(i);
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println(Thread.currentThread().getName()+"===="+threadLocal.get());

                            }
                        }finally {
                            threadLocal.remove();
                        }

                    }
                }, "thread1").start();



                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i < 100; i++) {
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());

                            }
                        }finally {
                            threadLocal.remove();
                        }
                    }
                }, "thread2").start();
            }
        }

        new TestDemo().doSomething();




    }



}
