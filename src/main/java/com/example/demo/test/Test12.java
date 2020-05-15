package com.example.demo.test;



import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;


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










        return;

    }


    @Test
    public void test1(){

        //流的内容比较
        File file1 = new File("D:\\1.txt");
        File file2 = new File("D:\\2.txt");

        try {
            InputStream inputStream1 = new FileInputStream(file1);
            InputStream inputStream2 = new FileInputStream(file2);
            boolean b = IoUtil.contentEquals(inputStream1, inputStream2);
            System.out.println("两个流内容是否相同"+b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void test2() throws IOException {

        //文件拷贝
        File file1 = new File("D:\\1.txt");
        File file3 = new File("D:\\3.txt");
        try {
            InputStream inputStream1 = new FileInputStream(file1);
            OutputStream outputStream3 = new FileOutputStream(file3);
            long copy = IoUtil.copy(inputStream1, outputStream3);
            System.out.println("流拷贝后的返回值："+copy);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        File file4 = FileUtil.file("d:\\3.txt");
        FileInputStream fileInputStream = IoUtil.toStream(file4);
        int i;
        byte[] buffer =new byte[1024];
        while ((i = fileInputStream.read(buffer))!=-1) {
            System.out.println(buffer);
        }
        fileInputStream.close();


    }

}




