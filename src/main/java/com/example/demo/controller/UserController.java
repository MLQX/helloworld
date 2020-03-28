package com.example.demo.controller;

import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class UserController {

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){

        User u = new User();
        u.setAge(18);
        u.setCreateTime(new Date());
        //u.setEmail("549918019@qq.com");
        u.setId(1L);
        u.setName("张三");
        u.setManagerId(12L );
        return u;
    }


}
