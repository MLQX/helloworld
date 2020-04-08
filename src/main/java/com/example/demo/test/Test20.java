//package com.example.demo.test;
//
//
//import com.example.demo.hutool.core.bean.DynaBean;
//import com.example.demo.hutool.core.collection.CollUtil;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * DynaBean
// */
//@Slf4j
//public class Test20 {
//
//
//    public static void main(String[] args) {
//
//        //动态bean
//        User2 user = new User2();
//        DynaBean dynaBean = DynaBean.create(User2.class,null); //使用Class类型作为参数后面必须要params参数
//        dynaBean.set("name", "张三");
//        dynaBean.set("id",1);
//        System.out.println(dynaBean.toString());
//
//        String name = dynaBean.get("name");//输出“张三”
//        System.out.println(name);
//
//        //invoke
//        Object invokeRet = dynaBean.invoke("shut");
//        System.out.println(invokeRet);
//        //CollUtil.newHashMap();
//    }
//
//
//}
//
//  class User2{
//    private int id;
//    private String name;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "User2{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    public boolean shut(){
//        System.out.println("shut down");
//        return false;
//    }
//}
//
//
//
//
//
