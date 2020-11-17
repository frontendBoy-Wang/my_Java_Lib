package com.wmq.demo04数组;

import java.util.ArrayList;

/*
题目:
| 定义以指定格式打T印集合的方法(AroyList类型作为参数),使用({扩起集合,使用@分隔每个元素。
格式参照{元素@元素@元素}。
Systemout.println(it);
[1),20, 38]
pirtrrylist(list);
[1@20@3Q}
*/
public class demo06ArrayListPrint {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add("张三丰");
        list.add("张4丰");
        list.add("张5丰");
        list.add("张6丰");
        System.out.println(list);

/*
定义方法的三要素
返回值类型:只是进行打印而已，没有运算，没有结果:所以用void
方法名称: pitrraylist
参数列表: Aroylist
*/
        printArrayList(list);
    }

    public static void printArrayList(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i == list.size() - 1) {
                System.out.println(name + "}");
            } else {
                System.out.print(name + "@");
            }


        }
    }
}






















