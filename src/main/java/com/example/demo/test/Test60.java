package com.example.demo.test;

import cn.hutool.dfa.WordTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 *
 *
 *  字符串 DFA 算法
 */

@Slf4j
public class Test60 {

    @Before
    public void before(){

    }
    //匹配[大, 土豆, 刚出锅]   标准匹配，匹配到最短关键词，并跳过已经匹配的关键词
    @Test
    public void test1() throws IOException {


        WordTree tree = new WordTree();

        tree.addWord("大");
        tree.addWord("大土豆");
        tree.addWord("土豆");
        tree.addWord("刚出锅");
        tree.addWord("出锅");


        //要查找、过滤关键词的正文部分
        String text = "我正在学习做菜，我做了有一颗大土豆，刚出锅的";

        List<String> strings = tree.matchAll(text, -1, false, false);
        log.debug(strings.toString());


    }

    //匹配[大, 土豆, 刚出锅, 出锅]    匹配到最短关键词，不跳过已经匹配的关键词
    @Test
    public void test2() throws IOException {


        WordTree tree = new WordTree();

        tree.addWord("大");
        tree.addWord("大土豆");
        tree.addWord("土豆");
        tree.addWord("刚出锅");
        tree.addWord("出锅");


        //要查找、过滤关键词的正文部分
        String text = "我正在学习做菜，我做了有一颗大土豆，刚出锅的";

        List<String> strings = tree.matchAll(text, -1, true, false);
        log.debug(strings.toString());


    }



    //匹配[大, 大土豆, 刚出锅]   匹配到最长关键词，跳过已经匹配的关键词
    @Test
    public void test3() throws IOException {


        WordTree tree = new WordTree();

        tree.addWord("大");
        tree.addWord("大土豆");
        tree.addWord("土豆");
        tree.addWord("刚出锅");
        tree.addWord("出锅");


        //要查找、过滤关键词的正文部分
        String text = "我正在学习做菜，我做了有一颗大土豆，刚出锅的";

        List<String> strings = tree.matchAll(text, -1, false, true);
        log.debug(strings.toString());


    }



    //匹配[大, 大土豆, 土豆, 刚出锅, 出锅]   匹配到最长关键词，不跳过已经匹配的关键词（最全关键词）
    @Test
    public void test4() throws IOException {


        WordTree tree = new WordTree();

        tree.addWord("大");
        tree.addWord("大土豆");
        tree.addWord("土豆");
        tree.addWord("刚出锅");
        tree.addWord("出锅");


        //要查找、过滤关键词的正文部分
        String text = "我正在学习做菜，我做了有一颗大土豆，刚出锅的";

        List<String> strings = tree.matchAll(text, -1, true, true);
        log.debug(strings.toString());


    }
}
