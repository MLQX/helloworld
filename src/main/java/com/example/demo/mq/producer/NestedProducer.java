package com.example.demo.mq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 利用sb脚手架的 消息发送者
 */
//@Component
public class NestedProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public void produce(String msg){
        rocketMQTemplate.convertAndSend("springboot-producer","hello,rocketmq&springboot!");
    }



}
