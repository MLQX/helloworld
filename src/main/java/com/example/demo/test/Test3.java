//package com.example.demo.test;
//
//import com.example.demo.hutool.core.lang.Console;
//import com.example.demo.hutool.core.lang.Editor;
//import com.example.demo.hutool.core.swing.clipboard.ClipboardUtil;
//import com.example.demo.hutool.core.util.ArrayUtil;
//import com.example.demo.hutool.core.util.ReflectUtil;
//import com.example.demo.hutool.core.util.TypeUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.awt.datatransfer.Clipboard;
//import java.lang.reflect.Array;
//import java.nio.ByteBuffer;
//import java.util.Map;
//
//
//@Slf4j
//public class Test3 {
//
//    public static void main(String[] args) {
//
//        // ArrayUtil
//
//        //判断 null 和 size == 0
//        int[] a = {};
//        int[] b = null;
//        Console.log(ArrayUtil.isEmpty(a));
//        Console.log(ArrayUtil.isEmpty(b));
//        int[] c = {1, 2, 3};
//        Console.log(ArrayUtil.isEmpty(c));
//
//
//        // 新建泛型数组
//        String[] newArr = ArrayUtil.newArray(String.class, 3);
//        newArr[0] = "U";
//        newArr[1] = "F";
//        newArr[2] = "O";
//        Console.log(newArr);
//
//
//        // ArrayUtil的filter方法, 分离偶数
//        Integer[] aa = {1, 2, 3, 4, 5, 7};
//        Integer[] filter = ArrayUtil.filter(aa, new Editor<Integer>() {
//            @Override
//            public Integer edit(Integer integer) {
//                return (integer % 2 == 0)? integer:null;
//            }
//        });
//
//        Console.log(filter);
//
//        //zip函数
//        String[] keys = {"a", "b", "c"};
//        Integer[] values = {1, 2, 3};
//        Map<String,Integer> ret = ArrayUtil.zip(keys, values);
//        Console.log(ret);
//        Console.log(ret.get("B"));
//        Console.log(ret.get("b"));
//
//
//        //是否包含函数
//        Integer[] ins = {1, 2, 3};
//        int[] ins2 = {1, 2, 3};
//
//        boolean isCon = ArrayUtil.contains(ins,3);
//        boolean isCon2 = ArrayUtil.contains(ins,5);
//        Console.log(isCon);
//        Console.log(isCon2);
//
//        boolean isCon3 = ArrayUtil.contains(ins2,8);
//        Console.log(isCon3);
//
//
//
//        // isArray判断对象是否是数组
//        boolean ret2 = ArrayUtil.isArray(isCon3);
//        boolean ret3 = ArrayUtil.isArray(ins2);
//        Console.log(ret2);
//        Console.log(ret3);
//
//        long[] ins3 = {1L, 2L, 3L};
//
//        Object[] ret4 = ArrayUtil.wrap(ins3);
//
//        Console.log((ret4[0]));
//
//        //获取ret4[0]的类型
//        Console.log(ret4[0].getClass().getTypeName());
//        Console.log(ret4.getClass().isArray());
//
//
//        //数组的toString
//        Console.log(ArrayUtil.toString(ins2));
//        Console.log(ArrayUtil.toString(ins3));
//
//        //数组的join
//        String ret5 = ArrayUtil.join(ins2, "%");
//        Console.log(ret5);
//
//
//        //数组的toArray,针对 ByteBuffer类型
//        //ByteBuffer byteBuffer = new HeapByteBuffer();
//        //ArrayUtil.toArray(byteBuffer);
//
//        //
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//
//}
//
//
//
//
