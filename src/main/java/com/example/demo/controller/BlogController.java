package com.example.demo.controller;

import lombok.Data;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BlogController {

    @GetMapping("/blogs")
    public Object getAll(){


        return "";
    }

    @PostMapping("/search")
    public Object search(@RequestBody Param param){
        Map<String, Object> map = new HashMap<>();
        StopWatch watch = new StopWatch();
        watch.start();

        if (param.getType().equalsIgnoreCase("mysql")) {
            // mysql 搜索

        } else if (param.getType().equalsIgnoreCase("es")) {
            // es 搜索

        }else{

        }

        watch.stop();
        long time = watch.getTotalTimeMillis();
        map.put("duration", time);
        return map;


    }



    @Data
    public static class Param{

        private String type;
        private String keyword;

    }



}
