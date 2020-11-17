package com.wmq.day01.demo02;

//导入包：import com.wmq.day01.demo02.demo02student
public class demo02student {


    public static void main(String[] args) {
        Student wmq=new Student();
//        使用成员变量
        System.out.println(wmq.name);//null
        System.out.println(wmq.age);//0

        wmq.name="汪满青";
        wmq.age=19;
        System.out.println(wmq.name);
        System.out.println(wmq.age);

        wmq.eat();
        wmq.sleep();
        wmq.study();

    }
}
