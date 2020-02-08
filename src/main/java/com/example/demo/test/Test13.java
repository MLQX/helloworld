package com.example.demo.test;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.io.watch.watchers.DelayWatcher;
import cn.hutool.core.lang.Console;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

import static cn.hutool.core.io.resource.ResourceUtil.getResource;


@Slf4j
public class Test13 {

    public static void main(String[] args) {

        //run1();
        //run2();
        run3();

    }
    static void run1() {
        //文件监听FileMonitor
        File file = FileUtil.file("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/example.properties");
        WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY, WatchMonitor.ENTRY_CREATE);
        watchMonitor.watch(new Watcher() {
            @Override
            public void onCreate(WatchEvent<?> watchEvent, Path path) {
                Object context = watchEvent.context();
                Console.log("创建:{}->{}", path, context);
            }

            @Override
            public void onModify(WatchEvent<?> watchEvent, Path path) {
                Object context = watchEvent.context();
                Console.log("修改:{}->{}", path, context);
            }

            @Override
            public void onDelete(WatchEvent<?> watchEvent, Path path) {
                Object context = watchEvent.context();
                Console.log("删除:{}->{}", path, context);
            }

            @Override
            public void onOverflow(WatchEvent<?> watchEvent, Path path) {
                Object context = watchEvent.context();
                Console.log("Overflow:{}->{}", path, context);
            }
        });

        watchMonitor.setMaxDepth(3);
        watchMonitor.start();

    }


    static void run2(){
        File file = FileUtil.file("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/example.properties");
        WatchMonitor watchMonitor = WatchMonitor.createAll(file,new SimpleWatcher(){
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Console.log("EVENT MODIFY");
            }
        });
        watchMonitor.start();

    }

    /**
     *
     * 防止短时间  多次触发 modify 操作
     */
    static void run3(){
        File file = FileUtil.file("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/example.properties");
        SimpleWatcher simpleWatcher = new SimpleWatcher() {
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Console.log("EVENT MODIFY");
            }
        };
        WatchMonitor monitor = WatchMonitor.createAll(file, new DelayWatcher(simpleWatcher, 500));
        monitor.start();
    }



}




