package com.example.demo.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        Integer[] nums = new Integer[10];
        Stream<Integer> stream = Arrays.stream(nums);



        //无限流 生成
        Stream<Double> limit = Stream.generate(Math::random).limit(10);
        limit.forEach(System.out::println);
        //无限流 迭代
        Stream<Integer> limit1 = Stream.iterate(1, (x) -> x + 2).limit(5);
        limit1.forEach(System.out::println);


        //HashMap<Object, Object> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        list.add(4);

        log.debug("当前list大小{}",list.size());


        //distinct()去除重复元素
        list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);


        list.add(35);
        list.add(16);
        list.add(87);


        // filter(),  过滤
        List<Integer> collect1 = list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 10;
            }

        }).collect(Collectors.toList());

        collect1.forEach(System.out::println);





        //该函数会被应用到每个元素上，并将其映射成一个新的元素
        list.stream().map(new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) {
                return String.valueOf(integer);
            }
        });

        list.stream().flatMap(new Function<Integer, Stream<?>>() {
            @Override
            public Stream<?> apply(Integer integer) {
                return Stream.of(integer);
            }
        });
        System.out.println("xxxxxxxxxxxx");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("xxxxxxxxxxxx");
        // 从大到小排
        list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                if (t1 < t2)
                    return 1;
                else
                    return -1;
            }
        }).forEach(System.out::println);



        //终止操作

        // allMatch
        boolean b = list.stream().allMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return true;
            }
        });
        log.debug("是否全部符合条件{}",b);

        list.add(4);

        System.out.println("**********************");
        list.forEach(System.out::println);
        Optional<Integer> any = list.stream().findAny();
        log.debug("从中任意返回一个值{}", any.get());



        //max,min,count
        Optional<Integer> max = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (integer > t1) {
                    return 1;
                }
                return -1;
            }
        });
        if (max.isPresent()) {
            Integer integer = max.get();
            System.out.println(integer);
        }


        long count = list.stream().count();
        log.debug("当前流的总元素大小为:{}",count);



        //reduce 归约



    }







    static void getSome(Object o){
        System.out.println("哈哈");
    }


}



enum Status{
    SLEPP,
    EAT,
    WORL
}



