package com.example.demo.mq.producer;

/*
*
* 发送同步消息  可靠性高性能低
* */

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

public class SyncProducer {
    public static void main(String[] args) {


        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("localhost:9876");
        try {
            producer.start();

            for (int i = 0; i < 10; i++) {
                Message msg = new Message("base", "Tag1", ("helloworld" + i).getBytes());
                SendResult sendResult = producer.send(msg);

                System.out.println("消息发送状态: "+sendResult);

                TimeUnit.SECONDS.sleep(1);

            }
            producer.shutdown();

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }


}
