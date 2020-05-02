package com.example.demo.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 *
 *
 * 二维码
 */

@Slf4j
public class Test54 {
    @Test
    public void test1() {


        //QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
        //扫描这个网站生成的二维码就等于打开这个网站
        //OutputStream out = new OutputStreamWriter();
        //QrCodeUtil.generate("https://www.baidu.cn/", 300, 300,"jpg");

        // decode -> "http://hutool.cn/"  识别二维码
        String decode = QrCodeUtil.decode(FileUtil.file("d:/qrcode.jpg"));
        log.debug(decode);








    }


}
