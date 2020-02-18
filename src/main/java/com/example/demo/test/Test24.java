package com.example.demo.test;


import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 *  图片工具类 ImgUtil
 */
@Slf4j
public class Test24 {


    public static void main(String[] args) throws IOException {


        String ip= "127.0.0.1";
        long iplong = 2130706433L;

        //根据long值获取ip v4地址
        String ip2= NetUtil.longToIpv4(iplong);


        //根据ip地址计算出long型的数据
        long ip3= NetUtil.ipv4ToLong(ip);

        //检测本地端口可用性
        boolean result= NetUtil.isUsableLocalPort(3307);

        //是否为有效的端口
        boolean result1= NetUtil.isValidPort(6379);

        //隐藏掉IP地址
        String result2 =NetUtil.hideIpPart(ip);

        return;



    }


}



