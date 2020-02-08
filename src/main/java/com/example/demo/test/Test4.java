package com.example.demo.test;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Slf4j
public class Test4 {

    public static void main(String[] args) {


        //随机获得一个字符串
        String ret = RandomUtil.randomString(3);
        Console.log(ret);
        //随机获得列表内一个元素
        int[] a = {1, 32, 332, 6717, -26,56,224,699,883,1524,99999,20200202};
        //转化为包装类数组
        Integer[] aa =ArrayUtil.wrap(a);


        // array -> list
        List<Integer> ret2 = Arrays.asList(aa);
        Console.log(RandomUtil.randomEle(ret2));

        //随机UUID
        String uuid = RandomUtil.randomUUID();
        Console.log(uuid);


        //从list中获得一定量不重复的元素，返回set
        Set mySet = RandomUtil.randomEleSet(ret2, 3);
        Console.log(mySet);


        // 获得指定位数的随机数字字符串
        String retNum = RandomUtil.randomNumbers(11);
        Console.log(retNum);











    }

}




