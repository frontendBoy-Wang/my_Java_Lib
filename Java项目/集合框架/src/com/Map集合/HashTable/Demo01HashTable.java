package com.Map集合.HashTable;

import java.util.HashMap;
import java.util.Hashtable;

/*
    java. util .Hashtable<K, V>集合implements Map<K, V>接口

    Hashtable:底层也是一一个哈希表,是一-个线程安全的集合，是单线程集合,速度慢
    HashMap:底层是一一个哈希表 是一一个线程不安全的集合， 是多线程的集合，速度快

    HashMop集合(之前学的所有的集合):可以存储ull值,null键
    Hashtable集合,不能存储ull值，nulL键

    Hashtable和Vector集合-样在jdk1. 2版本之后被更先进的集合(HashMap, ArrayList)取代了
    Hashtable的子类Properties依然活跃在历史舞台
    Properties集合是-一个唯一和I0流相结合的集合

 */
public class Demo01HashTable {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "a");
        map.put("b", null);
        map.put(null, null);
        System.out.println(map);

        Hashtable<String,String> table=new Hashtable<>();
        //Hashtable集合,不能存储ull值，nulL键
        table.put(null,"a");
        table.put("a",null);
        table.put(null,null);
        System.out.println(table);
    }
}
