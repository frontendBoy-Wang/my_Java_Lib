package com.Map集合.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/*
    java. util.linkedHashMap<K, V> extends HashMop<K, V>
    Map接口的哈希表和链接列表实现，具有可预知的迭代顺序。

    底层原理:
        哈希表+连表(记录元素的顺序)

 */
public class Demo01LinkedHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("c","c");
        map.put("b","b");
        map.put("a","d");
        System.out.println(map);//key不允许重复,无序{a=d, b=b, c=c}

        LinkedHashMap<String,String> linked=new LinkedHashMap<>();
        linked.put("a","a");
        linked.put("c","c");
        linked.put("b","b");
        linked.put("a","d");
        System.out.println(linked);//key不允许重复,有序{a=d, c=c, b=b}
    }
}
