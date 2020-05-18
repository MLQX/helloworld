package com.example.demo.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/5 22:36
 *
 *  CollUtil
 */
@Slf4j
public class Test64 {


    @Before
    public void before() {

    }

    @Test
    public void test1() {

        //Integer a = 127;
        //Integer b = 127;
        //System.out.println(a==b);
        //
        //Integer a2 = 128;
        //Integer b2 = 128;
        //System.out.println(a2==b2);
        //
        //Integer j = null;
        ////int i = j;
        ////System.out.println(i);  //NPE风险
        //
        //String str = "a,b,c,,";
        //String[] ary = str.split(",");
        //// 预期大于 3，结果是 3
        //System.out.println(ary.length);
        //
        //
        //ArrayList<String> arrayList = new ArrayList<>();
        //
        //
        //arrayList.add("1");
        //arrayList.add("3");
        //arrayList.add("5");
        //arrayList.add("7");
        //arrayList.add("9");
        //
        //List<String> strings = arrayList.subList(0, 3);
        //
        //strings.forEach(System.out::println);
        //
        //
        ////String s = strings.get(2);
        //strings.set(2, "25");
        //System.out.println(arrayList);  //子列表是父列表的一个视图，对子列表的操作对反映到父列表中
        //
        //
        //// list -> []
        //String[] strings1 = ArrayUtil.toArray(arrayList, String.class);
        //System.out.println(strings1);


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {

            String next = iterator.next();
            if ("2".contains(next)) {
                iterator.remove();
            }
        }

        while (iterator.hasNext()) {
            System.out.println("1"+iterator.next());

        }






    }
}
