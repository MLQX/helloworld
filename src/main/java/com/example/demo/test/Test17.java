package com.example.demo.test;


import cn.hutool.core.bean.BeanInfoCache;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.bean.copier.ValueProvider;

import cn.hutool.core.lang.Singleton;
import lombok.extern.slf4j.Slf4j;

import org.springframework.util.Assert;
import org.springframework.util.SocketUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
@Slf4j
public class Test17 {

    static void run1(){

        return;
    }

    static void run2(){
        class T{
            public int getQ() {
                return q;
            }

            public void setQ(int q) {
                this.q = q;
            }

            private int q;

        }

        boolean isBean = BeanUtil.isBean(T.class);
        System.out.println(isBean);

        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(T.class);
        System.out.println(propertyDescriptors);  //获取各个属性的描述
        //BeanUtil.getPropertyDescriptorMap()
        PropertyDescriptor qDescriptor = BeanUtil.getPropertyDescriptor(T.class, "q");
        System.out.println(qDescriptor);
    }

    /**
     * 注入 Bean
     */
    static void run3(){

        Person person = BeanUtil.fillBean(new Person(), new ValueProvider<String>() {
            @Override
            public Object value(String s, Type type) {
                switch (s) {
                    case "name":
                        return "张三"; //为属性name设置值
                    case "age":
                        return 18;  //为属性age设置值
                }
                return null;
            }

            @Override
            public boolean containsKey(String s) {
                return true;
            }
        }, CopyOptions.create());
        System.out.println(person.getName());
        System.out.println(person.getAge());
         //Assert.assertEquals(person.getName(), "张三");
         //Assert.assertEquals(person.getAge(), 18);
    }

    public static void main(String[] args) {
        run3();

    }


}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class SubPerson extends Person {
    public static final String SUBNAME = "TEST";

    private UUID id;
    private String subName;
    private Boolean isSlow;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getSubName() {
        return subName;
    }
    public void setSubName(String subName) {
        this.subName = subName;
    }
    public Boolean isSlow() {
        return isSlow;
    }
    public void setSlow(Boolean isSlow) {
        this.isSlow = isSlow;
    }





}


class Demo<M>{
    //private static M m;
    public static <T> void method(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        method("3t");
    }
}

abstract class MyFace<K> implements IFace<K> {

    @Override
    public void show(K k) {
        System.out.println(k);
    }
}


interface IFace <K>{
    void show(K k);

}