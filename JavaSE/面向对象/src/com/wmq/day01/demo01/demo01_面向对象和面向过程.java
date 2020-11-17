package com.wmq.day01.demo01;

import java.util.Arrays;

/*
 * 面向对象：当需要实现一个功能的时候，不关心具体的步骤，而是找一个已经具有该功能的人来帮我做事
 * 面向过程：当需要实现一个功能的时候，每一个具体的步骤都要亲力亲为，详细处理每一个细节
 * */
public class demo01_面向对象和面向过程 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40};

        //使用面向过程
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i] + "]");
            }else {
                System.out.print(array[i] + ",");
            }
        }
        System.out.println("=======================");
        //面向对象
        //找一个JDK给我们提供的Array类,
        // 其中有一个ToString方法,直接把数组变成想要的格式化字符串
        System.out.println(Arrays.toString(array));

    }
}
