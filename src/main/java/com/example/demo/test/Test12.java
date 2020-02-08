package com.example.demo.test;


import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Console;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;


@Slf4j
public class Test12 {

    public static void main(String[] args) {



        //IoUtil
        //BufferedInputStream in = FileUtil.getInputStream("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/a.txt");
        //BufferedOutputStream out = FileUtil.getOutputStream("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/b.txt");
        //long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);


        //将流封装为Writer和Reader
        //IoUtil.getWriter(out,);




        // FileTypeUtil
        //File file = FileUtil.file("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/a.txt");
        //String type = FileTypeUtil.getType(file);
        //Console.log(type);


        //FileReader使用
        //FileReader fileReader = new FileReader(file);
        //
        //String ret = fileReader.readString();
        //byte[] ret2 = fileReader.readBytes();
        //Console.log(ret);
        //Console.log(ret2);
        //
        ////将FileReader instance -> BufferedInputStream 和 BufferedReader
        //BufferedInputStream inputStream = fileReader.getInputStream();//针对字节流
        //BufferedReader reader = fileReader.getReader(); //针对字符流


        //FileWriter
        FileWriter fileWriter = new FileWriter("/sq/ruoan/workspace/helloworld/src/main/java/com/example/demo/test/b.txt");
        fileWriter.write("北京欢迎你"); //覆盖模式
        fileWriter.append("安徽不欢迎您");






        return;

    }

}




