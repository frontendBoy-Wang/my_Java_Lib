package com.Map集合.HashMap;

import java.util.HashMap;
import java.util.Map;

/*
    java. util .Map<k, v>集合
    Map集合的特点:
        1.Mop集合是一个双列集合,一个元素包含两个值(一个key,一个value)
        2.Map集合中的元素，key和value的数据类型可以相同，也可以不同
        3.Map集合中的元素, key是不允许重复的, value是可以重复的
        4.Map集合中的元素, key和value是一一对应

    java. util .HashMap<k, v>集合implements Map<k,v>接口
    HashMap集合的特点:
        1.HashMap集合底层是哈希表查询的速度特别的快
            JDK1.8之前数组+单向链表
            JDK1.8之后;数组单向链表/红黑树(链表的长度超过8):提高查询的速度
        2.hashMap集合是一-个无序的集合 ,存储元素和取出元素的顺序有可能不一致

    java.util.LinkedHashMap<k, v>集合extends HashMap<k, v>集合
     LinkedHashMap的特点:
        1.linkedHashMap集合底层是哈希表+链表(保证迭代的顺序)
        2.L inkedHashMap集合是- -个有序的集合,存储元素和取出元素的顺序是一 致的
Map常用方法:

 */
public class Demo01Map {
    public static void main(String[] args) {
        put();
        remove();
    }

    private static void remove() {
     /*
        public V remove(Object key):把指定的键所对应的键值对元素在Map集合中删除,返回被删余元素的值。
        返回值:V
        key存在, v返回被删除的值
        key不存在，v返回null
    */
        //创建Map集合对象
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖", 168);
        map.put("杨颖", 165);
        map.put("林志玲", 178);
        System.out.println(map);//{林志玲=178,赵丽颖=168, 杨颖=165}
        Integer v1 = map.remove("林志玲");
        System.out.println("v1 = " + v1);

    }

    private static void put() {
        /*
        public V put(K key, V value);把指定的键与指定的值添加到Map集合中。
        返回值:v
        存储键值对的时候，key不重复,返回值V是null
        存储键值对的时候，key重复,会使用新的value替换map中重复的volue,返回被替换的value值
        */
        //创建Map集合对象,多态
        Map<String, String> map = new HashMap<>();

        String v1 = map.put("李晨", "范冰冰1");
        System.out.println("v1:" + v1);//v1:null

        String v2 = map.put("李晨", "范冰冰2");
        System.out.println("v2:" + v2);//v2:范冰冰1

        System.out.println(map);//{李晨=范冰冰2}
        map.put("wmq", "zq");
        map.put("wmq1", "zq1");
        map.put("wmq2", "zq2");
        map.put("wmq3", "zq3");
        System.out.println(map);
    }
}
