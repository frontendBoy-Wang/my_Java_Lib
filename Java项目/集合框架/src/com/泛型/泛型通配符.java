package com.泛型;

import java.util.ArrayList;
import java.util.Iterator;

/*
泛型的通配符:
        ?:代表任意数据的数据类型
        使用方式;不能创建对象使用
        只能作为方法的参数使用
 */
public class 泛型通配符 {
    public static void main(String[] args) {
        ArrayList<Integer> list01=new ArrayList<>();
        list01.add(1);
        list01.add(2);
        list01.add(3);

        ArrayList<String> list02=new ArrayList<>();
        list02.add("a");
        list02.add("b");
        list02.add("c");

        printArray(list01);
        printArray(list02);
//        ArrayList<?> list03 = new ArrayList<?>();
    }

    private static void printArray(ArrayList<?> list) {
        //使用迭代器遍历集合
        Iterator<?> it=list.iterator();
        while (it.hasNext())
        {
//            next()取出的元素是object,可以接收任意类型
            Object object=it.next();
            System.out.println(object);
        }
    }

}
