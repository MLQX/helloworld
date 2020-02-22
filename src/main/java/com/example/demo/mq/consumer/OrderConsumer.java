package com.example.demo.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.Arrays;
import java.util.List;

public class OrderConsumer {


    public static void main(String[] args) {

        //1.新建push consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        //2.指定namesrv
        consumer.setNamesrvAddr("localhost:9876");
        // 可选项: 设定消费模式为广播,默认是负载均衡
        //consumer.setMessageModel(MessageModel.BROADCASTING);
        //3.指定订阅的topic和tag
        try {
            consumer.subscribe("OrderTopic","Order");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        //4.消息回调(消费消息)
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt ext : list) {

                    System.out.println(Thread.currentThread().getName() + ":消费了" + new String(ext.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }


        });
        //5.开启consumer
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
