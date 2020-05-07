package com.Collections集合工具类;
/*
java.utils.collections是集合工具类，用来对集合进行操作。部分方法如下:
public static <T> void sort(list<T> list):将集合中元素按照默认规则排序。
注意:
sort(List<T> list)使用前提
被排序的集合里边存储的元素,必须实现Comparable,重写接口中的方法compareTo定义排序的规则
Comparable接口的排序规则:
自己this-参数;升序
参数-this;降序
 */
import java.util.ArrayList;
import java.util.Collections;

public class Demo02Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        Collections.addAll(list01,1,4,3,2);
        System.out.println(list01);//[1, 4, 3, 2]

        //public static <T> void sort(list<T> list):将集合中元素按照默认规则排序。
        Collections.sort(list01);
        System.out.println(list01);//[1, 2, 3, 4]默认升序

        ArrayList<String> list02 = new ArrayList<>();
        Collections.addAll(list02,"w","b","f","z");
        Collections.sort(list02);
        System.out.println(list02);//[b, f, w, z]默认升序

        ArrayList<Person> list03 = new ArrayList<>();
        list03.add(new Person("wmq",18));
        list03.add(new Person("zq",19));
        list03.add(new Person("whl",17));

        Collections.sort(list03);
        System.out.println(list03);//[Person{name='whl', age=17}, Person{name='wmq', age=18}, Person{name='zq', age=19}]

    }
}
