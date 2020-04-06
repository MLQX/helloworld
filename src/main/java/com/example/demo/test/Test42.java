package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 *   测试VM 老年代、新生代  MINOR GC & FULL GC
 */

@Slf4j
public class Test42 {


    private byte[] b = new byte[1024 * 100];

    public static void main(String[] args) {


        List<Test42> list = new ArrayList<>();
        while (true) {
            list.add(new Test42());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }






}




