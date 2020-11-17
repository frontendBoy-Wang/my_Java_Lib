package com.Map集合.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    Map集合的第一中遍历方式:通过键找值的
    Map集合中的方法:
        Set<K> KeySet()返回此映射包含的键的Set视图
    实现步骤:
        1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一-个Set集合中
        2.遍历set集合,获取Mop集合中的每一-个key
        3.通过Map集合中的方法get(key),通过key找到value
 */
public class Demo02KeySet遍历1 {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<String,Integer> map=new HashMap<>();
        map.put("wmq1",168);
        map.put("wmq2",165);
        map.put("wmq3",178);

        //1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一-个Set集合中
        Set<String> set=map.keySet();

        //2.遍历set集合,获取Mop集合中的每一个key
        //使用迭代器遍历set集合
        Iterator<String> it=set.iterator();
        while (it.hasNext()){
            String k=it.next();
            Integer v=map.get(k);
            System.out.println(k+"="+v);
        }
        System.out.println("===================");
        //使用增强for循环遍历set集合
        for (String key : set) {
            Integer v=map.get(key);
            System.out.println(key+"="+v);
        }
    }
}
