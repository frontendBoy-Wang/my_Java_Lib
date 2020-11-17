package com.wmq.demo02匿名对象;

import java.util.Scanner;

public class demo02Anonymous {
    public static void main(String[] args) {
        //普通使用方式
//        Scanner sc=new Scanner(System.in);
//        int num=sc.nextInt();

        //匿名方式
//        int num1=new  Scanner(System.in).nextInt();
//        System.out.println("输入的是"+num1);

        //使用一般方式传入参数
//        Scanner sc = new Scanner(System.in);
//        methodParam(sc);

        //使用匿名对象来传递参数
//        methodParam(new Scanner(System.in));

        Scanner sc = methodReturn();
        int num = sc.nextInt();
        System.out.println("输入的是" + num);
    }

    public static void methodParam(Scanner sc) {
        int num = sc.nextInt();
        System.out.println("输入的书：" + num);
    }

    public static Scanner methodReturn() {
//        Scanner sc=new Scanner(System.in);
//        return sc;
        return new Scanner(System.in);
    }
}
