package com.wmq.demo04数组;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/*
题目:
    用一个大集合存入20个随机数字,然后筛选其中的偶数元素,放到小集合当中。
    要求使用自定义的方法来实现筛选。
分析:
    1.需要创建-一个大集合，用来存储it数字: <Integer>
    2.随机数字就用Random nextInt
    3.循环20次,把随机数字放入大集合: for循环、add方法
    4.对一个方法用来进行筛选

三要素
    近回值类型: ArrayList小集合 (里面元素个数不确定)
    方法名称: getSmallList
    参数列表: ArrayList大集合(装着2个随机数字)
    5.判断(if)是偶数:  num%2== 0
    6.如果是偶数，就故到小集合当中，否则不放。
*/
public class 集合类型筛选返回 {
    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100) + 1;
            bigList.add(num);
        }
        System.out.println("大集合里面的数字：" + bigList);

        ArrayList<Integer> smallList = getSamllList(bigList);
        System.out.println("偶数总共有：" + smallList.size() + "个");
        for (int i = 0; i < smallList.size(); i++) {
            System.out.print(smallList.get(i) + ",");
        }
    }

    public static ArrayList<Integer> getSamllList(ArrayList<Integer> bigList) {
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get(i);
            if (num % 2 == 0) {
                smallList.add(num);
            }
        }
        return smallList;
    }
}
