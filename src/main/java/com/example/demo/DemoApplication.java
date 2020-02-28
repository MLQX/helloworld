package com.example.demo;

import cn.hutool.cron.CronUtil;
import com.example.demo.mq.consumer.NestedConsumer;
import com.example.demo.mq.producer.NestedProducer;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    @Autowired
    private static NestedProducer producer;
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        //开启定时任务
        //CronUtil.start();



        //生产者发送默认消息
//        producer.produce(null);


    }

}
