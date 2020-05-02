package com.example.demo.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.multipart.UploadFile;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpBase;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 *
 *
 * 新建一个http服务器
 */

@Slf4j
public class Test55 {
    @Test
    public void test1() {


        //HttpUtil.createServer(8081).start();
        //try {
        //    Thread.sleep(20000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}


        //简单文件服务器
        //HttpUtil.createServer(8899)
        //        // 设置默认根目录
        //        .setRoot("D:\\workspace\\simple-web-test")
        //        .addAction("/hello",(request,response)->{
        //            //Gson gson = new Gson;
        //            //gson.toJson()
        //            response.write("{\"id\": 1, \"msg\": \"OK\"}", ContentType.JSON.toString());
        //        })
        //        .start();
        //
        //try {
        //    System.out.println("睡眠");
        //    Thread.sleep(60000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}


        //文件上传
        HttpUtil.createServer(8899)
                .addAction("/file", (req, res) -> {
                    final UploadFile uploadFile = req.getMultipart().getFile("file");
                    uploadFile.write("d://simple-web-test/");
                    res.write("OK!", ContentType.TEXT_PLAIN.toString());

                }).start();
        try {
            System.out.println("睡眠");
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
