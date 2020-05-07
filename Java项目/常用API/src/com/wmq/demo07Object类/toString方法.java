package com.wmq.demo07Object类;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class toString方法 {
//Person类默认继承了Object的toString方法
//    string toString()返回该对象的字符串表示

    public static void main(String[] args) {
        Person p = new Person("wmq", 20);
        String s = p.toString();
        System.out.println(s);//com.wmq.demo07Object类.Person@1b6d3586

//        直接打印对象的名字就是调用了对象的toString方法
        System.out.println(p);
//        看一个类是否重写了toString方法直接打印此类的名字即可
//        如果没有重写toString方法那么打印的就是对象的地址值(默认)
//        如果重写了toString方法就是按照重写的方式打印
        Random r=new Random();
        System.out.println(r);//没有重写里toString方法

        Scanner sc=new Scanner(System.in);
        System.out.println(sc);//重写里toString方法

        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);//重写里toString方法
    }
}
