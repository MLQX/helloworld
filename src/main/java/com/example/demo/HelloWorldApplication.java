package com.example.demo;

//import com.example.demo.mq.consumer.NestedConsumer;
//import com.example.demo.mq.producer.NestedProducer;

import cn.hutool.core.util.RuntimeUtil;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class HelloWorldApplication {

    //@Autowired
    //private static NestedProducer producer;
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
        //开启定时任务
        //CronUtil.start();


        //生产者发送默认消息
//        producer.produce(null);

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                System.out.println("哈哈");
                System.out.println("do ShutdownHook.......... ");
                //防止内存泄漏
                String ret1 = RuntimeUtil.execForStr("taskkill /im ffmpeg.exe /f");
                String ret2 = RuntimeUtil.execForStr("taskkill /im ffmpeg /f");
                System.out.println("clear Process step1:" + ret1);
                System.out.println("clear Process step2:" + ret2);
            }

        });

        System.out.println("******************************Version:0027***********************************");


    }

}




