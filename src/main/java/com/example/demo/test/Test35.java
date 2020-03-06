package com.example.demo.test;


import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
@Slf4j
public class Test35 {

    /**
     *
     *一、原理：
     * java动态代理： 利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
     *
     * cglib动态代理： 利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
     *
     * JDK动态代理和CGLIB字节码生成的区别？
     *
     * JDK动态代理只能对实现了接口的类生成代理，而不能针对类
     * CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法 因为是继承，所以该类或方法不要声明成final
     *
     *
     *
     */






}


interface UserManager{
    //新增用户抽象方法
    void addUser(String userName,String password);

    //删除用户抽象方法
    void delUser(String userName);
}


class UserManagerImpl implements  UserManager{
    //重写新增用户方法
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: "+userName+" password: "+password);
    }

    //重写删除用户方法
    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: "+userName);
    }

}

/**
 * jdk动态代理
 */
class JdkProxy implements InvocationHandler{


    private Object target;
    private Object getJdkProxy(Object target){
        this.target = target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("JDK 动态代理,监听开始");
        Object result = method.invoke(target, objects);

        System.out.println("JDK 动态代理,监听结束");
        return result;
    }

    public static void main(String[] args) {

        JdkProxy jdkProxy = new JdkProxy();
        UserManager user = (UserManager) jdkProxy.getJdkProxy(new UserManagerImpl());
        user.addUser("admin","123456");

    }
}

/**
 *
 * Cglib动态代理
 */

class CglibProxy implements MethodInterceptor{


    public Object getCglibProxy(Object target){


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        Object result = enhancer.create();
        return result;
    }

    //拦截方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib 动态代理,监听开始");
        //Object result = method.invoke(o, objects);
        Object invoke = methodProxy.invokeSuper(o, objects);

        System.out.println("Cglib 动态代理,监听结束");
        return invoke;
    }

    public static void main(String[] args) {


        CglibProxy cglibProxy = new CglibProxy();
        UserManager userManager = (UserManager)cglibProxy.getCglibProxy(new UserManagerImpl());
        userManager.delUser("admin");

    }



}




