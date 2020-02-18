package com.example.demo.test;


import cn.hutool.core.net.NetUtil;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 *  线程工具类 ThreadUtil
 */
@Slf4j
public class Test25 {


    public static void main(String[] args) throws IOException {



        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName());
            }
        });

        System.out.println("Hl");




    }


}



