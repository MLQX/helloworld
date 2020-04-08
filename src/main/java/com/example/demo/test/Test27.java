//package com.example.demo.test;
//
//
//import com.example.demo.hutool.core.lang.Console;
//import cn.hutool.cron.CronUtil;
//import cn.hutool.cron.task.Task;
//import cn.hutool.setting.Setting;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
///**
// *  定时任务
// */
//@Slf4j
//public class Test27 {
//
//
//    public static void main(String[] args) throws IOException {
//
//
//        CronUtil.schedule("*/30 * * * * *", new Task() {
//            @Override
//            public void execute() {
//                Console.log("Task executed...");
//            }
//
//        });
//        CronUtil.setMatchSecond(true); //支持秒级别定时任务
//        CronUtil.start(false);
//    }
//
//
//}
//
//
//
