//package com.example.demo.test;
//
//
//import com.example.demo.hutool.setting.Setting;
//import com.example.demo.hutool.setting.dialect.Props;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
///**
// *  Setting 文件读取
// */
//@Slf4j
//public class Test26 {
//
//
//    public static void main(String[] args) throws IOException {
//        //Properties p = new Properties();
//        //Class clz = Test26.class;
//        //InputStream in = clz.getResourceAsStream("example.properties");
//        //p.load(in);
//        //return;
//
//
//        //中文支持不好
//        //Props p = new Props("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/example.properties");
//        //System.out.println(p);
//
//
//
//        //Setting配置
//
//        Setting setting = new Setting("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/example.setting",true);
//        System.out.println(setting);
//
//        //获取key为user的值
//        //String user = setting.getStr("user","demo","");
//        //System.out.println(user);
//
//
//        System.out.println(setting.getByGroupWithLog("ds.setting.path", "demo"));
//    }
//
//
//}
//
//
//
