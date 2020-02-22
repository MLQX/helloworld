package com.example.demo.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class SQLFilterConsumer {


    public static void main(String[] args) {

        //1.新建push consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        //2.指定namesrv
        consumer.setNamesrvAddr("localhost:9876");
        // 可选项: 设定消费模式为广播,默认是负载均衡
        //consumer.setMessageModel(MessageModel.BROADCASTING);
        //3.指定订阅的topic和tag
        try {
            consumer.subscribe("SQLFilterTopic", MessageSelector.bySql("i<4"));
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        //4.消息回调(消费消息)
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt ext : list) {

                    System.out.println("延时时间:"+(System.currentTimeMillis()-ext.getStoreTimestamp()));
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
