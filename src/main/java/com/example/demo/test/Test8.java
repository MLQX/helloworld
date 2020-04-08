//package com.example.demo.test;
//
//
//import com.example.demo.hutool.core.lang.Console;
//import com.example.demo.hutool.core.util.IdcardUtil;
//import com.example.demo.hutool.core.util.ReUtil;
//import lombok.extern.slf4j.Slf4j;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
//@Slf4j
//public class Test8 {
//
//    public static void main(String[] args) {
//
//        //正则工具
//        //String content = "ZZZaaabbbccc中文1234";
//        //Pattern pattern = Pattern.compile("中文", Pattern.DOTALL);
//        //Matcher matcher = pattern.matcher(content);
//        //if (matcher.find()) {
//        //    String result = matcher.group();
//        //    Console.log(result);
//        //}else {
//        //    Console.log("Nothing");
//        //}
//
//
//
//        //分组的结果
//        String content2 = "ZZZ个ppaaff英文abbbccc中文1234";
//        String resultExtractMulti = ReUtil.extractMulti("(\\w)aa(\\w)", content2, "$1-$2");
//        Console.log(resultExtractMulti);
//
//        String content3 = "ZZZaaabbbccc中文1234";
//        //从原来的字符串删除匹配到的字符串
//        String resultDelFirst = ReUtil.delFirst("(\\w)aa(\\w)", content3);
//        Console.log(resultDelFirst);
//
//
//        //findAll方法
//        String content4 = "ZZZaaabbbccc中文1234";
//        List<String> resultFindAll = ReUtil.findAll("\\w{2}", content4, 0, new ArrayList<String>());
//        // 结果：["ZZ", "Za", "aa", "bb", "bc", "cc", "12", "34"]
//        Console.log(resultFindAll);
//
//        //获取第一个数字
//        Integer resultGetFirstNumber = ReUtil.getFirstNumber(content4);
//        Console.log(resultGetFirstNumber);
//
//
//        //isMatch
//        String content5 = "ZZZaaabbbccc中文1234";
//        boolean isMatch = ReUtil.isMatch("\\w+[\u4E00-\u9FFF]+\\d+", content5);
//        Console.log(isMatch);
//
//        //replaceAll方法
//        String content6 = "ZZZaaabbbccc中文1234";
//        String replaceAll = ReUtil.replaceAll(content6,"(\\d+)","->$1<-");
//        Console.log(replaceAll);
//
//
//
//
//
//
//    }
//
//}
//
//
//
//
