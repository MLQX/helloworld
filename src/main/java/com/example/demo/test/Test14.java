//package com.example.demo.test;
//
//
//import com.example.demo.hutool.core.io.FileUtil;
//import com.example.demo.hutool.core.io.resource.ClassPathResource;
//import com.example.demo.hutool.core.io.watch.SimpleWatcher;
//import com.example.demo.hutool.core.io.watch.WatchMonitor;
//import com.example.demo.hutool.core.io.watch.Watcher;
//import com.example.demo.hutool.core.io.watch.watchers.DelayWatcher;
//import com.example.demo.hutool.core.lang.Console;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Path;
//import java.nio.file.WatchEvent;
//import java.util.Properties;
//
//import static com.example.demo.hutool.core.io.resource.ResourceUtil.getResource;
//
///**
// * 通过 ClassPathResource 加载配置文件
// */
//@Slf4j
//public class Test14 {
//
//    public static void main(String[] args) {
//
//        //run1();
//        //run2();
//        run5();
//
//    }
//    static void run4(){
//        String path = "config.properties";
//        //InputStream in = this.class.getResource(path).openStream();
//    }
//
//
//    /**
//     *
//     */
//    static void run5(){
//        ClassPathResource resource = new ClassPathResource("test.properties");
//
//        Properties p = new Properties();
//        try {
//            p.load(resource.getStream());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Console.log("Properties {}",p);
//
//    }
//}
//
//
//
//
