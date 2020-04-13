package com.example.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 */


public class Test50 {
    @Test
    public void test1(){

    }

    public interface List<E>{
        void add(E x);



        Iterator<E> iterator();
        E put();

    }
    public interface Map<K, V>{
        Set<K> keySet();
        V put(K key,V value);
    }


    public interface StringList extends List{

        //@Override
        //void add(String x);

        @Override
        Iterator<String> iterator();

        @Override
        String put();
    }


    public class Tt<K>{
        public void say(){
            System.out.println("say");
        }
    }

    public static void main(String[] args) {
        //Tt tt = new Test50.new Tt();
        //tt.say();

    }


}

class Apple<K>{
    private int num;
    public Apple() {
        //Apple<String>(3);
    }

    public Apple(int num) {
        this.num = num;
    }
}


class Cat<K>{
    K info ;
    void setCat(K k){

    }
    K getCat(){
        return info;
    }
}
//注意：  class SS extends Cat<K> 是不合法的，但class SS<K> extends Cat<K> 是合法的

class SS extends Cat<String>{
    //泛型被确定为String后，继承的两个方法的 K 位置也被替换为了 String
    @Override
    void setCat(String s) {
        super.setCat(s);
    }

    @Override
    String getCat() {
        return super.getCat();
    }
}

/**
 * 如果本身是泛型类，被继承的话，相当于子类继承了  Cat<Object>
 */
class SSS extends Cat{
    @Override
    void setCat(Object o) {
        super.setCat(o);
    }

    @Override
    Object getCat() {
        return super.getCat();
    }

    public static void main(String[] args) {
        //SS ss =new SS();
        //SSS sss = new SSS();
        //System.out.println(sss.getClass() == ss.getClass());

        List<String> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        System.out.println(li1.getClass()==li2.getClass());

    }
}



