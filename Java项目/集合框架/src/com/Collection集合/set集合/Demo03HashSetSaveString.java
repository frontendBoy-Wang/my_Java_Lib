package com.Collection集合.set集合;

import java.util.HashSet;
/*
Set集合不允许重复的元素的原理
 */
public class Demo03HashSetSaveString {
    public static void main(String[] args) {
        //创建HashSet集合对象
        HashSet<String> set=new HashSet<>();
        String s1=new String("abc");
        String s2=new String("abc");
        set.add(s1);
        set.add(s2);
        set.add("重地");
        set.add("通话");
        set.add("abc");
        System.out.println(set);
    }
}
