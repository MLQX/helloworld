//package com.example.demo.test;
//
//import com.example.demo.hutool.core.util.ReflectUtil;
//import com.example.demo.hutool.core.util.TypeUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//@Slf4j
//public class Test {
//
//    public static void main(String[] args) {
//        //获得参数类型
//        Method method = ReflectUtil.getMethod(TestClass.class, "intTest", Integer.class);
//        Type type = TypeUtil.getParamType(method,0);
//        log.debug("type value is: " + type );
//
//
//        //获得返回类型
//        Method method1 = ReflectUtil.getMethod(TestClass.class, "getList");
//        Type type2 = TypeUtil.getReturnType(method1);
//        log.debug("type2 value is: " + type2 );
//
//
//        //getTypeArgument 获取泛型类子类中泛型的填充类型
//        Method method2 = ReflectUtil.getMethod(TestClass.class, "getList");
//        Type type3 = TypeUtil.getReturnType(method2);
//        Type type4 = TypeUtil.getTypeArgument(type3);
//        log.debug("type4 value is: "+type4);
//
//    }
//
//}
//
//class TestClass{
//
//    public List<String> getList(){
//        return new ArrayList<>();
//    }
//
//    public Integer intTest(Integer integer) {
//        return 1;
//    }
//}
