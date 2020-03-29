package com.example.demo.test;

import cn.hutool.core.io.FileUtil;
import com.example.demo.pojo.User;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.tools.ant.util.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * gson
 */

@Slf4j
public class Test39 {


    public static void main(String[] args) {

        //Map<String, Object> map = new HashMap<>();
        //map.put("id", 1);
        //map.put("username", "张三");
        //map.put("age", 18);
        //map.put("gender", "female");
        //map.put("major", "art");
        //Gson gson = new Gson();
        //String result = gson.toJson(map);
        //
        //log.debug(result);


         //bean -> json
        //User user = new User();
        //user.setName("hello");
        //user.setId(1L);
        //user.setEmail("549918019@qq.com");
        //user.setAge(11);
        //Gson gson = new Gson();
        //String s = gson.toJson(user);
        //log.debug(s);




        //读取json文件
        //File f = new File("./src/main/resources");
        //log.debug("完整路径为："+f.getAbsolutePath());
        //String[] names = f.list();
        //Arrays.stream(names).forEach(System.out::println);
        ////log.debug(String.valueOf(f.listFiles()));


        //
        File file = new File(Test39.class.getResource("/data.json").getFile());
        String s = FileUtil.readString(file, Charset.defaultCharset());
        log.debug(s);

        Gson gson = new Gson();
        User user = gson.fromJson(s, User.class);
        log.debug(user.toString());
    }
}
