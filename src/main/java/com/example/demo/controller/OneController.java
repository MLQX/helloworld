package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/4 21:16
 */

/**
 * 用于OneIntercetor拦截试验
 */
@RestController
@RequestMapping("/one")
public class OneController {
    @GetMapping("/showOne")
    public String showOne() {
        return "one";
    }
}
