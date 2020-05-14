package com.example.demo.test;

import cn.hutool.core.date.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 *
 *
 * 时间
 */

@Slf4j
public class Test53 {
    @Test
    public void test1() {


        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        log.debug("");

        //字符串转日期
        String dateStr = "2017-01-31";
        Date date4 = DateUtil.parse(dateStr);
        log.debug(date4.toString());
        String dateStr2 = "2017-01-31 16:44:21";
        Date date5 = DateUtil.parse(dateStr2,"yyyy-MM-dd HH:mm:ss");
        log.debug(date5.toString());


        //格式化日期输出
        String dateStr3 = "2017-03-01";
        Date date6 = DateUtil.parse(dateStr);

        //结果 2017/03/01
        String format = DateUtil.format(date6, "yyyy/MM/dd");

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date6);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date6);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date6);


        log.debug("----------------------------");

        String dateStr4 = "2017-03-01 22:33:23";
        Date date7 = DateUtil.parse(dateStr);

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date7);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date7);
        String dateStr5 = "2017-03-01 22:33:23";
        Date date8 = DateUtil.parse(dateStr);

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay2 = DateUtil.beginOfDay(date7);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay2 = DateUtil.endOfDay(date7);

        DateTime dateTime = DateUtil.endOfMonth(date8);
        DateTime dateTime2 = DateUtil.beginOfMonth(date8);




    }

    @Test
    public void test2() {
        //获取今天到月末的天数
        long between = DateUtil.between(DateUtil.date(), DateUtil.endOfMonth(DateUtil.date()), DateUnit.DAY);
        System.out.println(between);


        //获取当前时间的String
        String now = DateUtil.now();
        System.out.println(now);


        TimeInterval timer = DateUtil.timer();
        String today = DateUtil.today();
        System.out.println(today); //获取当前日期

        int i = DateUtil.ageOfNow(DateUtil.parse("1995-03-12"));
        System.out.println(i);

        int i2 = DateUtil.ageOfNow(DateUtil.parse("1994/03/12"));
        System.out.println(i2);

        int i3 = DateUtil.ageOfNow(DateUtil.parse("19960312"));
        System.out.println(i3);

        String s = DateUtil.formatTime(DateUtil.date());//获取当前的系统时间
        System.out.println(s);


        String chineseZodiac = DateUtil.getChineseZodiac(1995);  //生肖
        System.out.println(chineseZodiac);

        DateTime time = DateUtil.beginOfWeek(DateUtil.date()); //获取这个星期的开始时刻
        System.out.println(time);


        StopWatch stopWatch = DateUtil.createStopWatch();
        DateTime ceiling = DateUtil.ceiling(new Date(), DateField.HOUR);
        System.out.println(DateUtil.format(ceiling,"yyyy-MM-dd HH:mm:ss"));

        DateTime ceiling2 = DateUtil.ceiling(new Date(), DateField.SECOND);
        System.out.println(DateUtil.format(ceiling2,"yyyy-MM-dd HH:mm:ss"));


        //年的最后一刻
        DateTime ceiling3 = DateUtil.ceiling(new Date(), DateField.YEAR);
        System.out.println(DateUtil.format(ceiling3,"yyyy-MM-dd HH:mm:ss"));


        //月的最后一刻
        DateTime ceiling4 = DateUtil.ceiling(new Date(), DateField.MONTH);
        System.out.println(DateUtil.format(ceiling4,"yyyy-MM-dd HH:mm:ss"));


        System.out.println(new Date());
        System.out.println("hello");





    }


}
