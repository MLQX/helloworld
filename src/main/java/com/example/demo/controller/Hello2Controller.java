package com.example.demo.controller;

import com.example.demo.utils.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/6/12 14:57
 */
@RestController
@RequestMapping("/user")
public class Hello2Controller {

    @RequestMapping("/hello")
    public Map login(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie c :
                cookies) {
            if ("token".equals(c.getName())) {
                return  JwtUtil.validateToken(c.getValue());
            }
        }
        return null;
    }
}
