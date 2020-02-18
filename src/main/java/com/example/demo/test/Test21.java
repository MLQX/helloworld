package com.example.demo.test;


import cn.hutool.core.bean.DynaBean;
import lombok.extern.slf4j.Slf4j;

/**
 * isAssignableFrom
 */
@Slf4j
public class Test21 {


    public static void main(String[] args) {


        System.out.println(Cat.class.isAssignableFrom(Animal.class));
        System.out.println(Animal.class.isAssignableFrom(Cat.class));  //方法调用者是父类, 方法参数是子类

    }


}
class Animal {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Cat extends Animal{

    void bark(){
        System.out.println("喵喵");
    }
}




