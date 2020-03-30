package com.example.demo.interceptor;

import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.ConstructorInvocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.AccessibleObject;

/**
 * MethodInterceptor的实际使用
 */
public class MyInterceptor implements MethodInterceptor, ConstructorInterceptor {
    @Override
    public Object construct(ConstructorInvocation constructorInvocation) throws Throwable {
        debug(constructorInvocation.getConstructor(),constructorInvocation.getThis(),constructorInvocation.getArguments());
        return constructorInvocation.proceed();
    }

    private void debug(AccessibleObject ao, Object aThis, Object[] arguments) {


        System.out.println(ao);
        System.out.println(aThis);
        System.out.println(arguments);

    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        debug(methodInvocation.getMethod(),methodInvocation.getThis(),methodInvocation.getArguments());
        //return methodInvocation.proceed();    //这里可以控制方法最终会不会被执行

        return null;
    }






}

class MyTest{
    //目标方法
    public String doSomeThing(String someThing){

        //int i=5/0;
        return "执行被拦截的方法："+someThing;
    }

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();  //代理工厂对象
        proxyFactory.setTarget(new MyTest());  //设置target
        proxyFactory.addAdvice(new MyInterceptor()); //添加 advice
        Object proxy = proxyFactory.getProxy();  //获取到代理对象
        MyTest myTest = (MyTest) proxy;
        System.out.println(myTest.doSomeThing("猴赛雷啊"));  //通过代理对象调用方法

    }

}



