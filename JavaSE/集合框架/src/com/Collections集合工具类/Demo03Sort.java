package com.Collections集合工具类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
java. utils.Collections是集合工具类， 用来对集合进行操作。部分方法如下:
public static <T> void sort(list<T> list, Comparator<? super T> ):将集合中元素按照指定规则排序。
Comparator和Comparable的区别
Comparable:自己(this)和别人(参数)比较，自己需要实现Comparable接口，重写比较的规则
Comparator:相当于找第三方的裁判,比较两个
 */
public class Demo03Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(3);
        list01.add(2);
        list01.add(0);
        System.out.println(list01);

        Collections.sort(list01, new Comparator<Integer>() {
            //重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;//升序
                //return o2-o1;//升序
            }
        });
        System.out.println(list01);

        ArrayList<Student> list02 = new ArrayList<>();
        list02.add(new Student("awmq1", 18));
        list02.add(new Student("wmq2", 20));
        list02.add(new Student("wmq3", 17));
        list02.add(new Student("bwmq3", 18));

       /* Collections.sort(list02, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序输出
                return o1.getAge()-o2.getAge();
            }
        });*/
        Collections.sort(list02, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序输出
                int result = o1.getAge() - o2.getAge();
                //
                if (result == 0) {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list02);
    }
}
