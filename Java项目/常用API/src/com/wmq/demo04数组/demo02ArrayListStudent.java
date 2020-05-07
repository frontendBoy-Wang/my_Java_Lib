package com.wmq.demo04数组;

import java.util.ArrayList;

/*
题目:
自定义4个学生对象，添加到集合，并遍历。
1.自定义Student学生类, 四个部分。
2.创建一个集合，用来存储学生对象。泛型: <student>
3.根据类,创建4个学生对象。
4.将4个学生对象添加到集合中: add
5.遍历集合: for. sie. get
 */
public class demo02ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();

        Student a=new Student("洪七公",20);
        Student b=new Student("欧阳锋",21);
        Student c=new Student("黄药师",22);
        Student d=new Student("段智兴",23);

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            System.out.println("姓名："+stu.getName()+",年龄："+stu.getAge());
        }
    }


}
