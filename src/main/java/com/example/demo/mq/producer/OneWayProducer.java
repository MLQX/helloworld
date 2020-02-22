package com.example.demo.mq.producer;

/*
*
* 发送异步消息  性能高
* */

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

public class OneWayProducer {
    public static void main(String[] args) {


        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("localhost:9876");
        try {
            producer.start();

            for (int i = 0; i < 10; i++) {
                Message msg = new Message("base", "Tag2", ("helloworld" + i).getBytes());
                producer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.println("消息发送状态: "+sendResult);
                    }
                    @Override
                    public void onException(Throwable throwable) {
                        System.err.println("发送异常");
                    }
                });



                TimeUnit.SECONDS.sleep(1);

            }
            producer.shutdown();

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        }
    }


}
