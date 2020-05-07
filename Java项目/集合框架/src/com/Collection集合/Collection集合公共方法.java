package com.Collection集合;

import java.util.ArrayList;
import java.util.Collection;

/*
java.util.Collection接口
    所有单列集合的最顶层的接口，里边定义了所有单列集合共性的方法
    任意的单列集合都可使Collection接口中的方法
共性的方法:
    public boolean add(E e):把给定的对象称到当前集合中 。
    public void clear() :清空集合中所有的元素。
    public boolean remove(E e);把给定的对象在当前集合中删除。
    public boolean contains(E e);: 判当前集合中是否包含给定的对象。
    public boolean isEmpty();为断当前集合是否为空。
    public int size();返回集合中元素的个数。
    public Object[] toArray():把集合中的元素，存储到数组中。
**/
public class Collection集合公共方法 {
    public static void main(String[] args) {
        //创建一个集合对象,可以使用多态
        Collection<String> collection = new ArrayList<>();
        System.out.println(collection);//重写了toString方法

//        public boolean add(E e):把给定的对象称到当前集合中 。
//        返回值是一个boolean值,一般返回true,所以不用接受
        boolean b1 = collection.add("赵琴");
        System.out.println("b1:" + b1);//true
        System.out.println(collection);
        collection.add("汪满青");
        collection.add("张三");
        collection.add("李四");
        collection.add("赵六");
        System.out.println(collection);//[赵琴, 汪满青, 张三, 李四, 赵六]

//        public boolean remove(E e);把给定的对象在当前集合中删除。
//          返回值是一个boolean值,集合中存在元素,删除元素,返回true
//                                    不存在元素,删除失败,返回false
        boolean b2 = collection.remove("赵六");
        System.out.println("b2:" + b2);

        boolean b3 = collection.remove("赵四");
        System.out.println("b3:" + b3);
        System.out.println(collection);

//        public boolean contains(E e);: 判当前集合中是否包含给定的对象。
//          包含返回true,不包含返回false
        boolean b4 = collection.contains("李四");
        System.out.println("b4:" + b4);
        boolean b5 = collection.contains("赵四");
        System.out.println("b5:" + b5);

//        public boolean isEmpty();为断当前集合是否为空。
//        集合为空返回true,不为空返回false
        boolean b6 = collection.isEmpty();
        System.out.println("b6:" + b6);

//         public int size();返回集合中元素的个数。
        int b7 = collection.size();
        System.out.println("b7:" + b7);

//        public Object[] toArray():把集合中的元素，存储到微组中。
        Object[] arr = collection.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

//        public void clear() :清空集合中所有的元素。但是不删除集合,集合还在
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());




    }
}
