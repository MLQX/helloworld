//package com.example.demo.mq.consumer;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
////@RocketMQMessageListener(topic="springboot-producer",consumerGroup = "${rocketmq.consumer.group}")
////@Component
//@Slf4j
//public class NestedConsumer implements RocketMQListener<String> {
//
//    @Override
//    public void onMessage(String s) {
//        log.debug("当前接收到的消息为: "+s);
//
//    }
//}
