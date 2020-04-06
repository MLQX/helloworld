package com.example.demo.test;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *   jsoup 解析 xml/html
 */

@Slf4j
public class Test43 {




    public static void main(String[] args) {

        //String html = "<html><body><p>Hello HTML</p></body></html>";
        //Document doc = Jsoup.parse(html);
        //
        //Elements as= doc.getElementsByTag("p");
        //for (Element e : as) {
        //    System.out.println(e.text());
        //}
        //将文件转化为string
        File file = new File(Test43.class.getClassLoader().getResource("app.xml").getFile());
        String s = FileUtil.readString(file, Charset.defaultCharset());
        //System.out.println(s);

        // 解析string，得到各个节点的值
        Document document = Jsoup.parse(s);
        Elements say = document.getElementsByTag("say");
        System.out.println(say.size());
        //System.out.println(say.text());
        for (Element ele : say) {
            System.out.println(ele.text());
        }


    }






}




