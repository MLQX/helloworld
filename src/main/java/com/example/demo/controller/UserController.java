package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
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

        try {
            inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }

}
