package com.example.demo.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.pojo.Student2;
import com.example.demo.pojo.Student3;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@Controller
@Slf4j
public class UserController {

    @RequestMapping("/getUser")
    public User getUser(){

        User u = new User();
        u.setAge(18);
        u.setCreateTime(new Date());
        //u.setEmail("549918019@qq.com");
        u.setId(1L);
        u.setName("张三");
        u.setManagerId(12L);
        return u;
    }

    @RequestMapping("/throwException")
    public int throwException(){


        int i  = 1 / 0 ;
        return i;
    }
    @RequestMapping("/toPage")
    public ModelAndView toPage(){

        ModelAndView modelAndView = new ModelAndView("a");
        return modelAndView;
    }


    @RequestMapping("/setUser")
    public User setUser(User user){
        //
        //User u = new User();
        //u.setAge(18);
        //u.setCreateTime(new Date());
        ////u.setEmail("549918019@qq.com");
        //u.setId(1L);
        //u.setName("张三");
        //u.setManagerId(12L);
        //return u;
        log.debug(String.valueOf(user));
        return null;
    }


    @RequestMapping("/gd")
    public String gd(){
        //
        //User u = new User();
        //u.setAge(18);
        //u.setCreateTime(new Date());
        ////u.setEmail("549918019@qq.com");
        //u.setId(1L);
        //u.setName("张三");
        //u.setManagerId(12L);
        //return u;
        //log.debug(String.valueOf(user));
        return "gd";
    }


    /**
     * 测试content-length在长链接中的作用
     */
    @RequestMapping("/contentLength")
    public void contentLength (HttpServletRequest request, HttpServletResponse response){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File file = FileUtil.file("d:\\line.png");
        InputStream inputStream =null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[1024];
            int flag;
            while ((flag = bufferedInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer);
            }
            //头部contentLength做文章
            response.setHeader("Content-Length", String.valueOf(byteArrayOutputStream.size()));
            //response.setHeader("Content-Type","application/octet-stream");  //提示客户端下载这个文件
            //response.setHeader("Content-Type","application/pdf");  //如果是pdf文档，就直接在界面加载
            byteArrayOutputStream.writeTo(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }

    /**
     * 原生json
     */
    @RequestMapping(value = "/jsonNative")
    @ResponseBody
    public Student3 jsonNative (HttpServletRequest request, HttpServletResponse response){
        Student3 student3 = new Student3(9,"",null,null,"北京市");
        return student3;
    }


    /**
     * 原生json 带produces
     */
    @RequestMapping(value = "/jsonNative2",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Student3 jsonNative2 (HttpServletRequest request, HttpServletResponse response){
        Student3 student3 = new Student3(9,"",null,null,"北京市");
        return student3;
    }



    /**
     *
     * 返回String类型的 json
     *
     * 测试 fastjson消息转换器是否起效果
     */
    @RequestMapping(value="/jsonNull",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String jsonNull (HttpServletRequest request, HttpServletResponse response){

        Student3 student3 = new Student3(9,"",null,null,"北京市");
        String jsonObject = JSON.toJSONString(student3, SerializerFeature.WriteNullStringAsEmpty);
        //response.setHeader("Content-Type","application/json;charset=UTF-8");  //这种设置方法不行 用 produces才行
        log.debug(jsonObject);
        return jsonObject;



    }


    /**
     * 返回JSONObject
     *
     * 测试 fastjson消息转换器是否起效果
     */
    @RequestMapping(value="/jsonNull2")
    @ResponseBody
    public Object jsonNull2 (HttpServletRequest request, HttpServletResponse response){


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grade", 9);
        jsonObject.put("tel", "");
        jsonObject.put("addr", null);
        jsonObject.put("province", null);
        jsonObject.put("city", "北京市");
        return jsonObject;



    }


}
