package com.example.demo.mq.producer;

/*
*
* 发送事务消息
* */

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

public class TransactionProducer {
    public static void main(String[] args) {


        TransactionMQProducer producer = new TransactionMQProducer("group1");
        producer.setNamesrvAddr("localhost:9876");


        // 设置事务监听器
        producer.setTransactionListener(new TransactionListener() {
            /**
             * MQProducer在收到消息队列有关发送的半消息 的回送后,自主进行事务状态提交
             * @param message
             * @param o
             * @return
             */
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                if ("Tag1".equals(message.getTags())){
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else if("Tag2".equals(message.getTags())){
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else {
                    return LocalTransactionState.UNKNOW;
                }
            }

            /**
             * 当上一个方法返回UNKNOWN状态时, 消息队列会在一段时间后对事务状态进行回访,以确定 提交或回滚
             * @param messageExt
             * @return
             */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                System.out.println("当前消息的tag为:"+messageExt.getTags());
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        });
        try {
            producer.start();
            String[] tags = {"Tag1", "Tag2", "Tag3"};
            for (int i = 0; i < 3; i++) {
                Message msg = new Message("TransactionTopic",tags[i] , ("helloworld" + i).getBytes());
                SendResult sendResult = producer.sendMessageInTransaction(msg,null); //arg参数是对具体的消息进行事务控制

                System.out.println("消息发送状态: "+sendResult);

                TimeUnit.SECONDS.sleep(1);

            }
            //为了后期回调,不应关掉producer
            //producer.shutdown();

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
