//package com.example.demo.test;
//
//
//import com.example.demo.hutool.core.lang.Dict;
//import com.example.demo.hutool.core.lang.Singleton;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Singleton 对象池 (懒汉模式)
// */
//@Slf4j
//public class Test16 {
//
//    static void run1(){
//
//        return;
//    }
//
//    public static void main(String[] args) {
//        SingletonDemo.Animal dog = Singleton.get(SingletonDemo.Dog.class);
//        SingletonDemo.Animal cat = Singleton.get(SingletonDemo.Cat.class);
//
//        //单例对象每次取出为同一个对象，除非调用Singleton.destroy()或者remove方法
//        System.out.println(dog == Singleton.get(SingletonDemo.Dog.class));        //True
//        System.out.println(cat == Singleton.get(SingletonDemo.Cat.class));            //True
//
//        dog.say();        //汪汪
//        cat.say();        //喵喵
//    }
//
//
//}
//
//
//class SingletonDemo {
//
//    /**
//     * 动物接口
//     * @author loolly
//     *
//     */
//    public static interface Animal{
//        public void say();
//    }
//
//    /**
//     * 狗实现
//     * @author loolly
//     *
//     */
//    public static class Dog implements Animal{
//        @Override
//        public void say() {
//            System.out.println("汪汪");
//        }
//    }
//
//    /**
//     * 猫实现
//     * @author loolly
//     *
//     */
//    public static class Cat implements Animal{
//        @Override
//        public void say() {
//            System.out.println("喵喵");
//        }
//    }
//
//
//}
//
//
//
