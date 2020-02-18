package com.example.demo.test;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Function;
/**
 *
 */
@Slf4j
public class Test19 {
    static void run2(){
        //四大函数型接口
        // 1.消费型接口 Consumer  有参无返
        // void accept(T var1);
        // 传入的参数实现Consumer接口
        //testConsumer(10000,money-> System.out.println("我消费了"+money+"元"));
        //testConsumer(10000, new Consumer<Double>() {
        //    @Override
        //    public void accept(Double aDouble) {
        //
        //    }
        //});
        // 2.供给型接口Supplier, 无参有返
        // T get()
        //ArrayList<Integer> li = testSupplierByRandom(() -> {
        //    double res = Math.random() * 100;
        //    return new Double(res).intValue();
        //});
        //li.forEach(System.out::println);

        // 3.函数型接口Function, 有参有返
        // R apply(T t)
        //String sourceStr = "一花异世界,一树一批提";
        //System.out.println(testFunction(sourceStr, s -> s + "!"));

        // 4.断言型接口Predicate, 有参返回boolean
        // boolean test(T t)


        List<String> list = Arrays.asList("北京", "上海", "南京", "武汉", "杭州");
        ArrayList<String> resList = testPredicate(list, item -> item.contains("京"));
        //resList.forEach(item-> System.out.println(item));
        Test19 t19 = new Test19();
        resList.forEach(t19::mockPrint);
    }


    /**
     * 模拟打印
     */
     void mockPrint(String pattern){
        System.out.println(pattern);

    }

    static ArrayList<String> testPredicate(List<String> li, Predicate<String> predicate){


        ArrayList<String> newLi = new ArrayList<>();

        //li.stream().filter(item->predicate.test(item));
        for (String str:li) {
            if (predicate.test(str)) {
                //如果通过断言条件
                newLi.add(str);
            }
        }
        return newLi;
    }


    //static String testFunction(String sourceStr,Function<String,String> func){
    //
    //    //这个提供接口方法的调用
    //    return func.apply(sourceStr);
    //
    //}

    //static void testConsumer(double money,Consumer<Double>  consumer){
    //    consumer.accept(money); //调用Consumer接口的accept方法
    //}
    //
    //static ArrayList<Integer> testSupplierByRandom(Supplier<Integer> supplier){
    //    ArrayList<Integer> list = new ArrayList<>();
    //    //将list里填充满接口产生的数据
    //    for (int i = 0; i < 50; i++) {
    //        list.add(supplier.get());
    //    }
    //    return list;
    //}





    public static void main(String[] args) {
        run2();

    }



}






