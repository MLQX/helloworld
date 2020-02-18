package com.example.demo.test;


import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 *  布隆过滤器
 */
@Slf4j
public class Test28 {

    private static int size = 1000000; // 数据规模
    private static double fpp = 0.001; //误判率期望
    private static BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(),size, fpp);


    public static void main(String[] args) throws IOException {
        //填充数据
        for (int i = 0; i < 1000000; i++) {
            filter.put(i);
        }
        int count = 0;
        for (int j = 1000000; j < 2000000; j++) {
            if (filter.mightContain(j)) {
                count++;
                System.out.println(j+"可能误判了!");

            }

        }
        System.out.println("误判总数:"+count);





    }


}



