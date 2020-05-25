package com.example.demo.test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/5 22:36
 *
 *  EventBus  Guava
 */
@Slf4j
public class Test65 {


    @Before
    public void before() {

    }

    @Test
    public void test1() {

        // 事件类
        class EventTest{
            private final int msg;
            public EventTest(int m){
                msg = m;
            }
            public int getMsg(){
                return msg;
            }
        }

        // 监听者
        class EventListener{
            private  int lastMsg;
            @Subscribe
            public void listen(EventTest eventTest){
                lastMsg=eventTest.getMsg();
                System.out.println("LastMessage:"+lastMsg);
            }
            public int getLastMsg(){
                return lastMsg;
            }
        }



        EventBus eventBus = new EventBus("test");
        // 登记一个listener
        EventListener listener = new EventListener();
        eventBus.register(listener);
        // 发送三个事件 dispatch
        eventBus.post(new EventTest(100));
        eventBus.post(new EventTest(300));
        eventBus.post(new EventTest(500));

    }




    @Test
    public void test2() {



    }



}
