package com.example.demo.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * stream
 */
@Slf4j
public class Test29 {


    public static void main(String[] args) throws IOException {


        // arr->stream
        //int[] a = {1, 2, 3};
        //System.out.println(Arrays.stream(a).filter(i -> i % 2 == 0).findFirst().getAsInt());


        List<Integer> li = new LinkedList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(-1);
        boolean allMatch = li.stream().allMatch(i -> i > 0);
        boolean anyMatch = li.stream().anyMatch(i -> i > 0);
        boolean noneMatch = li.stream().noneMatch(i -> i > 10);
        System.out.println(allMatch);
        System.out.println(anyMatch);
        System.out.println(noneMatch);


        Optional<Integer> first = li.stream().findFirst();
        Optional<Integer> last = li.stream().skip(3).findFirst(); //获取最后一个流的方式
        if (first.isPresent()) {
            System.out.println(first.get());
        }
        if (last.isPresent()) {
            System.out.println(last.get());
        }
        Optional<Integer> randomOne = li.stream().skip(3).findAny();
        randomOne.ifPresent(System.out::println);


        li.stream().forEach(System.out::println);


        List<Integer> collect = li.stream().collect(Collectors.toList());
        System.out.println(Collection.class.isAssignableFrom(li.getClass()));
        System.out.println(List.class.isAssignableFrom(li.getClass()));
        System.out.println(ArrayList.class.isAssignableFrom(li.getClass()));
        System.out.println(LinkedList.class.isAssignableFrom(li.getClass()));

        //将Collection->Array
        Object[] array = li.stream().toArray();
        System.out.println(array);
        class T {

        }
        T[][] ts = {
                new T[0],
                new T[0],
                new T[0],
        };

        System.out.println(ts);


        //获取流中集合元素的个数
        Long collectSize = li.stream().collect(Collectors.counting());
        System.out.println(collectSize);


        //对集合中整数元素求和

        @AllArgsConstructor
        @Data
        class User {
            private String name;
            private Integer age;
        }
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 18));
        users.add(new User("李四", 21));
        users.add(new User("王五", 12));

        users.stream().collect(Collectors.summingInt(User::getAge));

        users.forEach(Test29::getSome);



    }


    static void getSome(Object o){
        System.out.println("哈哈");
    }


}



