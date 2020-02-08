package com.example.demo.test;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ZipUtil;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Test6 {

    public static void main(String[] args) {

        //压缩工具
        //ZipUtil.zip("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/Test6.java");

        //压缩文件夹
        ZipUtil.zip("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test");




    }

}




