package com.example.demo.mq.consumer;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息消费者(push)
 */
public class MyConsumer {
    public static void main(String[] args) {

        //1.新建push consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        //2.指定namesrv
        consumer.setNamesrvAddr("localhost:9876");
        // 可选项: 设定消费模式为广播,默认是负载均衡
        consumer.setMessageModel(MessageModel.BROADCASTING);
        //3.指定订阅的topic和tag
        try {
            consumer.subscribe("base","Tag1");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        //4.消息回调(消费消息)
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //List<String> collect = list.stream().map(MessageExt::getBody)
                //        .map(item -> item.toString()).collect(Collectors.toList());
                //collect.forEach(System.out::println);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //5.关闭consumer
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }




    }
}
