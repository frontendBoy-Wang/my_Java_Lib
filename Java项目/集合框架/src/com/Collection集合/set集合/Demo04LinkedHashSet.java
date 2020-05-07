package com.Collection集合.set集合;
/*
java.util.L inkedHashSet集合extends HashSet集合
LinkedHashSet集合特点:
底层是一个哈希表(数组+链表/红黑树)+链表:多了一条链表(记录元素的存储顺序), 保证元素有序

 */

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Demo04LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set1=new HashSet<>();
        set1.add("www");
        set1.add("abc");
        set1.add("abc");
        set1.add("itc");
        System.out.println(set1);//[abc, www, itc]无序不允许重复

        LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add("www");
        linkedHashSet.add("abc");
        linkedHashSet.add("abc");
        linkedHashSet.add("itc");
        System.out.println(linkedHashSet);//[www, abc, itc]有序不允许重复
    }
}
