package com.wmq.demo07Object类;

import java.util.Random;

/*Person 类默认继承了object类 所以可以使用object类的equals()方法
* boolean equals(Object obj)指示其他某个对象是否与此对象"相等"*/
public class equals类 {
    public static void main(String[] args) {
        Person p1=new Person("wmq",20);
        Person p2=new Person("wmq",20);

        System.out.println("p1"+p1);
        System.out.println("p2"+p2);
//        p1=p2;
/*
        public boolean equals(Object obj) {
            return (this == obj);
        }

        参数:
            Object obj:可以传递任意值
        方法体:
               ==比较运算符返回的是一个布尔值true,false
               基本数据类型:比较的是值
               引用数据类型:比较的是两个对象的地址值
        */

        Random r=new Random();

        boolean b=p1.equals(p2);
        System.out.println(b);//返回false 没有重写里equals()方法
//

    }
}
