package com.wmq.demo04数组;

import java.util.ArrayList;
/*
/*
如果希望向集合ArrayList当中存储基本类型数据，必须使用基本类型对应的咆装类”。
基本类型包装类 (引用类型，包装类都位于java. lang包下)
byte    Byte
short   Short
int     Integer[特殊]
long    Long
float   Float
double  Double
char    Character[特殊]
boolean Boolean

从JDK1.5+开始支持自动装箱，自动拆箱
自动装箱：基本类型-->包装类型
自动拆箱：包装类型-->基本类型
 */

public class demo05ArrayList基本数据类型 {
    public static void main(String[] args) {
//        错误写法，泛型只能是引用类型，不能是基本类型
//        ArrayList<String> list=new ArrayList<>();

          ArrayList<Integer> listC=new ArrayList<>();
          listC.add(100);
          listC.add(200);
        System.out.println(listC);

        int num=listC.get(1);
        System.out.println("第一号元素是："+num);
    }
}
