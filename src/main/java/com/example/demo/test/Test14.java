package com.example.demo.test;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.io.watch.watchers.DelayWatcher;
import cn.hutool.core.lang.Console;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.Properties;

import static cn.hutool.core.io.resource.ResourceUtil.getResource;

/**
 * 通过 ClassPathResource 加载配置文件
 */
@Slf4j
public class Test14 {

    public static void main(String[] args) {

        //run1();
        //run2();
        run5();

    }
    static void run4(){
        String path = "config.properties";
        //InputStream in = this.class.getResource(path).openStream();
    }


    /**
     *
     */
    static void run5(){
        ClassPathResource resource = new ClassPathResource("test.properties");

        Properties p = new Properties();
        try {
            p.load(resource.getStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Console.log("Properties {}",p);

    }
}




