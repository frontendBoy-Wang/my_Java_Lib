package com.Collection集合.List集合;

import java.util.LinkedList;

/*
java.util.LinkedList集合,implement list集合
LinkedList集合的特点
    1.底层是一个链表结构:查询慢,增删快
    2.里面包含了大量操作首尾元素的方法
    注意:使用LinkedList集合特有的方法,不能使用多态

    - public void addFirst(E e):将指定元素插入此列表的开头。
    - public void addLost(E e):将指定元素添加到此列表的结尾。
    - public void push(E e):将元素推入此列表所表示的堆栈。

    - public E getFirst():返回此列表的第一 一个元素。
    - public E getLast():返回此列表的最后一个元素。

    - public E removeFirst():移除并返回此列表的第一 个元素。
    - public E removeLast():移除并返回此列表的最后一个元素。
    - public E pop():从此列表所表示的堆栈处弹出一个元素。

    - public boolean isEmpty(): 如果列表不包含元素，则返回true。

 */
public class Demo02LinkedList集合 {
    public static void main(String[] args) {
        show03();

    }

    private static void show03() {
        //创建LinkedList集合
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);
       //- public E removeFirst():移除并返回此列表的第一 个元素。
       //- public E removeLast():移除并返回此列表的最后一个元素。
       //- public E pop():从此列表所表示的堆栈处弹出一个元素。

        //String first = linked.removeFirst();
        String first = linked.pop();
        System.out.println("被移除的第一个元素:"+first);
        String last = linked.removeLast();
        System.out.println("被移除的最后一个元素:"+last);
        System.out.println(linked);
    }

    private static void show02() {
        //创建LinkedList集合
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");

        linked.clear(); //清空集合中的元素

        //- public boolean isEmpty(): 如果列表不包含元素，则返回true。
        if(!linked.isEmpty()){
            //- public E getFirst():返回此列表的第一 一个元素。
            //- public E getLast():返回此列表的最后一个元素。
            String first = linked.getFirst();
            System.out.println(first);
            String last = linked.getLast();
            System.out.println(last);
        }

    }

    private static void show01() {
        //创建LinkedList集合
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);//[a, b, c]

        //- public void addFirst(E e):将指定元素插入此列表的开头。
        //linked.addFirst("www");
        //System.out.println(linked);//[www, a, b, c]
        //- public void push(E e):将元素推入此列表所表示的堆栈。
        //addFirst方法等同于push方法
        linked.push("www");
        System.out.println(linked);//[www, a, b, c]
        //- public E getLast():返回此列表的最后一个元素。
        linked.addLast("com");
        System.out.println(linked);//[www, a, b, c, com]

        System.out.println("=========================");

    }
}

















