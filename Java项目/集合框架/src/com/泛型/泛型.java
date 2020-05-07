package com.泛型;

import java.util.ArrayList;
import java.util.Iterator;

public class 泛型 {
    public static void main(String[] args) {
        show2();
    }

    /*
        创建集合对象，使用泛型
        好处:
            1.避免了类型转换的麻烦，存储的是什么类型输出的就是什么类型
            2.把运行期异常(代码运行之后会抛出的异常),提升到了编译期

    */
    private static void show2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        //list.add(1);

        //使用迭代器遍历list集合
        //获取迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext())
        {
            String s=it.next();
            System.out.println(s);
        }
    }
    /*
        创建集合对象,不使用泛型
            好处;集合不使用泛型,默认的类型是Object类型,可以存储任意类型的数据
            弊端:不安全,会引发异常

     */

    private static void show() {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add(1);

        //使用迭代器遍历list集合
        //获取迭代器
        Iterator it = list.iterator();
        //使用迭代器中的hasNext()和next()方法遍历集合
        while (it.hasNext()) {
            //取出的元素是object类型
            Object obj = it.next();
            System.out.println(obj);
            //想要使用String类特有的方法，length获取字符串的长度;不能使用多态 object obj= "abc";
            //需要向下转型
            //会抛出ClassCastException类型转领异常,不能把Integer类型转换为string类型
            String s = (String) obj;
            System.out.println(s.length());

        }
    }


}
