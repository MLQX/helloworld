package com.example.demo.mq.producer;


import com.example.demo.other.OrderStep;
import com.example.demo.utils.OrderStepBuilder;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * 延迟消息生产者
 */
public class DelayProducer {
    public static void main(String[] args) throws Exception {



        //1.默认生产者
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //2.设定namesrv
        producer.setNamesrvAddr("localhost:9876");
        //3.开启生产者
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        //4.构建消息
        List<OrderStep> orderStepList = OrderStepBuilder.build();
        for (int i = 0; i < orderStepList.size(); i++) {
            Message message = new Message("OrderTopic", "Order",orderStepList.get(i).toString().getBytes() );


            //设定消息延迟级别  level=2代表5秒
            message.setDelayTimeLevel(2);
            //5.发送消息
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                /**
                 *
                 * @param list
                 * @param message
                 * @param o
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    long orderId = (long) o;
                    long index = orderId % list.size();
                    return list.get((int) index);
                }
            }, orderStepList.get(i).getOrderId());
            System.out.println("消息发送状态"+sendResult);
        }
        //6.关闭生产者
        producer.shutdown();



    }

}
