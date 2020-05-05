package com.example.demo.test;

import cn.hutool.core.thread.GlobalThreadPool;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.dfa.WordTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/5 22:36
 */
@Slf4j
public class Test61 {


    @Before
    public void before() {

    }

    @Test
    public void test1() {

        //ExecutorService executor = GlobalThreadPool.getExecutor();//获取executor


        //直接在公共线程池里执行线程
        //ThreadUtil.execute(new Runnable() {
        //    @Override
        //    public void run() {
        //        log.debug("gg");
        //    }
        //});
        //log.debug("pp");


        //新的线程池
        //ExecutorService executorService = ThreadUtil.newExecutor();
        //executorService.execute(new Runnable() {
        //    @Override
        //    public void run() {
        //        log.debug("gg2");
        //    }
        //});

        //ThreadUtil.execAsync(); //异步任务

        //sleep方法
        //boolean sleep = ThreadUtil.sleep(1000);
        //if (sleep) {
        //    log.debug("已睡眠");
        //}


        //堆栈列表和堆栈顶
        //StackTraceElement[] stackTrace = ThreadUtil.getStackTrace();
        //log.debug(stackTrace.toString());
    }
}
