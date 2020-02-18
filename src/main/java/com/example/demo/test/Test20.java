package com.example.demo.test;


import cn.hutool.core.bean.DynaBean;
import lombok.extern.slf4j.Slf4j;

/**
 * DynaBean
 */
@Slf4j
public class Test20 {


    public static void main(String[] args) {

        //动态bean
        User user = new User();
        DynaBean dynaBean = DynaBean.create(user);
        dynaBean.set("name", "张三");
        dynaBean.set("age",18);
        dynaBean.toString();
    }


}

  class User{
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




