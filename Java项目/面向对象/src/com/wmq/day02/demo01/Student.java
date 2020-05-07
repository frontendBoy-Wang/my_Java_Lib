package com.wmq.day02.demo01;
/*
* 标准的类：
* 1：所有的成员都要用private关键字修饰
* 2：为每一个成员编写一对Getter/Setter方法
* 3：编写一个无参数的构造方法
* 4：编写一个全参数的构造方法*/

public class Student {//标准的类
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
