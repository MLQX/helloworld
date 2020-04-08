//package com.example.demo.test;
//
//
//import com.example.demo.hutool.core.convert.Convert;
//import com.example.demo.hutool.core.date.*;
//import com.example.demo.hutool.core.lang.Console;
//import com.example.demo.hutool.core.util.StrUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Date;
//import java.util.List;
//
//
//@Slf4j
//public class Test11 {
//
//    public static void main(String[] args) {
//
//        // date(),now(),today()
//        //Console.log(DateUtil.now());
//        //Console.log(DateUtil.today());
//        //Date date = DateUtil.date();
//        //Console.log(date);
//
//        String format = "2019-12-16";
//        //Date date2 = DateUtil.parse(format,"yyyy-MM-dd");
//        //Date date3 = DateUtil.parse(format,"yyyy/MM/dd");
//        //Console.log(date2);
//        //Console.log(date3);
//
//        Date date = DateUtil.parse(format);
//        String ret =DateUtil.format(date, "yyyy/MM/dd");
//        String ret2 =DateUtil.format(date, "yyyyMMdd");
//        Console.log(ret);
//        Console.log(ret2);
//
//        // time,date,datetime
//        Console.log(DateUtil.formatTime(date));
//        Console.log(DateUtil.formatDate(date));
//        Console.log(DateUtil.formatDateTime(date));
//
//        //
//        Date date2 = DateUtil.date();
//        int year = DateUtil.year(date2);
//        int month = DateUtil.month(date2);
//        int day = DateUtil.dayOfMonth(date2);
//        Console.log(StrUtil.format("year{}-month{}-day{}",year,month,day));
//
//
//        //日期时间偏移
//        DateTime dateTime =DateUtil.offset(date2, DateField.HOUR, 1);
//        DateTime dateTime2 =DateUtil.offset(date2, DateField.HOUR, -1);
//        Console.log(dateTime);
//        Console.log(dateTime2);
//
//
//        // between 比较时间
//        String dateStr1 = "2017-03-01 22:33:23";
//        Date date11 = DateUtil.parse(dateStr1);
//
//        String dateStr2 = "2017-04-01 23:33:23";
//        Date date22 = DateUtil.parse(dateStr2);
//
//        //相差一个月，31天
//        long betweenDay = DateUtil.between(date11, date22, DateUnit.DAY);
//        Console.log(betweenDay);
//
//        //精确到分钟,31天1小时
//        String formatBetween = DateUtil.formatBetween(date11, date22, BetweenFormater.Level.MINUTE);
//        Console.log(formatBetween);
//
//        TimeInterval timer = DateUtil.timer();
//
//        //---------------------------------
//        //-------这是执行过程
//        //---------------------------------
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long t = timer.interval();//花费毫秒数
//        timer.intervalRestart();//返回花费时间，并重置开始时间
//        timer.intervalMinute();//花费分钟数
//        Console.log(t);
//
//        //年龄
//        Console.log(DateUtil.ageOfNow("1990-04-30"));
//
//        //是否闰年
//        Console.log(DateUtil.isLeapYear(2017));
//
//
//        //DateTime
//        Date date3 = new Date();
//        //构建方式1
//        DateTime dateTime3 = new DateTime(date3);
//        //构建方式2
//        DateTime dateTime4 = DateTime.now();
//        //构建方式3
//        DateTime dateTime5 = DateTime.of(date3);
//        //构建方式4
//        DateTime dateTime6 = new DateTime("2002-03-26", DatePattern.NORM_DATETIME_FORMAT);
//
//    }
//
//}
//
//
//
//
