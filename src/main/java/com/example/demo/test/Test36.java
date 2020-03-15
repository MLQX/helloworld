package com.example.demo.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;

/**
 *  简单的JDK代理
 */
@Slf4j
public class Test36 {





    public static void main(String[] args) throws IOException {


        MyJdkProxy myJdkProxy = new MyJdkProxy();
        //通过代理方法创建实例
        ISayHi o = (ISayHi) myJdkProxy.setExample(new SayHiImpl());
        o.sayHi();


    }





}
// jdk代理要实现 InvocationHandler接口
class MyJdkProxy implements InvocationHandler{

    private Object target;
    /**
     * 获得代理对象
      * @param target
     * @return
     */
    public Object setExample(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    /**
     * 处理代理方法
     * @param proxy 被代理的对象
     * @param method 被代理的方法
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始");
        Object invoke = method.invoke(target, args);
        System.out.println("代理结束");

        return invoke;
    }
}



interface ISayHi{
    void sayHi();
}



class SayHiImpl implements ISayHi{

    @Override
    public void sayHi() {
        System.out.println("SayHiImpl->sayHi()");
    }
}


