package com.wmq.day01.demo03;

public class Person {
    String naem;
    private int age;

    public void show() {
        System.out.println("我叫" + naem + "年龄" + age);
    }

    public void setAge(int num) {
        if (num >= 0 && num <= 100) {
            age = num;
        } else {
            System.out.println("数据不合理");
        }
    }

    public int getAge() {
        return age;
    }
}
