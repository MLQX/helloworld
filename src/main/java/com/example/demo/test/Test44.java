package com.example.demo.test;


import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.charset.Charset;

/**
 *   冒泡排序算法
 */

@Slf4j
public class Test44 {

    public void bubbleSort(Integer[] arr, int n) {
        if (n <= 1) return;       //如果只有一个元素就不用排序了

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    //int temp = arr[j];
                    //arr[j] = arr[j + 1];
                    //arr[j + 1] = temp;
                    //flag = true;
                    //reverse(arr[j],arr[j+1]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    flag = true;
                }

            }
            if (!flag) break;//没有数据交换，数组已经有序，退出排序
        }
    }


    //void reverse(int a,int b){
    //    int c;
    //    c=a;
    //    a=b;
    //    b=c;
    //}

    public static void main(String[] args) {

        Integer arr[] = {2, 4, 7, 6, 8, 5, 9};
        for (int a : arr) {
            System.out.print(a+" ");
        }
        System.out.println("\n");
        //SortUtil.show(arr);
        //Test44 bubbleSort = new Test44();
        //bubbleSort.bubbleSort(arr, arr.length);
        ////SortUtil.show(arr);
        //for (int a : arr) {
        //    System.out.print(a+" ");
        //}

        if (arr.length <= 1) {
            return;
        }
        int i,j;
        for (i = 0; i < arr.length; i++) {

            boolean flag = false;
            for (j = 0; j < arr.length-i-1; j++) {
                //出现需要排列的情况
                if (arr[j] > arr[j + 1]) {  // j+1 <= arr.length-1  -> j <= ar
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    flag = true;
                }



            }
            if (!flag) {
                //表示一趟下来，没有需要排序的
                break; //退出外层循环
            }

        }

    }








}




