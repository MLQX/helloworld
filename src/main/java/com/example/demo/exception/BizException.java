package com.example.demo.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BizException {




    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleExp(HttpServletRequest req, HttpServletResponse rsp, Exception ex){

        ex.printStackTrace();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",ex);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");  // error.html 全局错误页面
        return modelAndView;
    }
}
