package com.example.demo.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
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

    @Test
    public void test5(){

        String text = "一个很直接的感受就是：视频只关照到了“一小部分”青年，而忽略了太多生活中应该得到更多鼓励的青年。\n" +
                "视频里，那些出国体验高空跳伞的、那些在闹市区穿汉服的、那些在电竞舞台恣意挥洒激情的，画面看起来都很酷，配合何冰老师节奏拿捏得恰到好处的演说以及慷慨激昂的音乐，的确能够给人带来很澎湃的观感。\n" +
                "做这样的青年多好啊，能够有很多选择的权利，能够体验丰富的生活。\n" +
                "但是，放在现实生活里，这些炫酷到令人心情澎湃的青年状态，其实只能发生在“一小部分”人身上。大部分的青年人，那些生活在农村、小城里对未来感到迷茫的青年人，那些毕业后满怀希望却屡屡碰壁的青年人，那些才步入社会没多久就不得不考虑买房买车等问题的青年人，那些为了能在大城市拼出点成绩而努力加班的青年人，那些成绩优异、能力出众却敌不过“有背景”、“有关系”的那一撮人的青年人，他们的生活，也是这么炫酷吗？\n" +
                "大多数的青年人，压力不比中年人小。他们可能完全不渴望过得有多炫酷，只会希望压力能小一点点、人生能更顺利一点点、生活能更好一点点。\n" +
                "不是所有人都渴望自己的人生要活成如你们所认为的那种“精彩”，他们可能只希望自己的人生能平安健康地与家人一起，过一种幸福的小日子，哪怕平平淡淡，哪怕一点都不酷。\n" +
                "我们要理解这样的青年人，也要关照到这样的青年人，更要鼓励、认可这样的青年人。\n" +
                "B站的这支《后浪》确实能让不少人感到激情澎湃，尤其B站的用户似乎更能get到它所表达的重点。追逐自由，追求梦想，勇敢体验，丰富经历，接纳多元，这些都是符合B站氛围与文化的重点，从“广告效应”而言，这支视频算得上是一个很不错的案例。\n" +
                "但若是基于整个“青年”群体而言，这支视频的所关注和关照到的面显得窄了一些。\n" +
                "其实我个人更想知道的是：今时今日，到底怎样的人，能称之为“青年”？\n" +
                "我个人想提一种希望：希望所有青年们能够多一些独立思考、多一些勇敢、多一些包容、多一些善良，少一些情绪化的判断、少一些键盘上的攻击，在大多数人都不太发声的情况下，要学会包容不同的观点，不要动不动就举报。";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            sb.append("【"+(i+1)+"】"+text);
        }


        //log.debug(sb.toString());

        TimeInterval timer = DateUtil.timer();
        //第一种方法
        boolean ret = sb.toString().contains("【499800】一");
        int place = sb.toString().indexOf("【499800】一");
        long interval = timer.interval();
        log.debug("第一种方法返回结果是否包含："+ret);
        log.debug("第一种方法返回结果位置："+place);
        log.debug("第一种方法时间："+interval);
        timer.restart();
        //第二种方法
        WordTree wordTree = new WordTree();
        wordTree.addWord("【499800】一");
        boolean match = wordTree.isMatch(sb.toString());
        String match1 = wordTree.match(sb.toString());
        log.debug("第二种方法返回结果是否包含："+match);
        log.debug("第二种方法返回结果字符串："+match1);
        interval = timer.interval();
        log.debug("第二种方法时间："+interval);


    }
}
