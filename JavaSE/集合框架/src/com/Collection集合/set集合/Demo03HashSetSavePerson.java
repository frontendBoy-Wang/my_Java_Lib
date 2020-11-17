package com.Collection集合.set集合;

import java.util.HashSet;

/*
HashSet存储自定义类型元素
Set集合报错元素唯一:
存储的意思(String,Integer......)必须重写hashCode方法和equals方法
要求:同年龄的人,视为同一个人,只能存储一次
 */
public class Demo03HashSetSavePerson {
    public static void main(String[] args) {
    //创建hashCode集合存储Person
        HashSet<Person1> set=new HashSet<>();
        Person1 p1=new Person1("wmq",18);
        Person1 p2=new Person1("wmq",18);
        Person1 p3=new Person1("wmq",19);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }
}

class Person1{
    private String name;
    private int age;

    public Person1() {
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person1 person1 = (Person1) o;

        if (age != person1.age) {
            return false;
        }
        return name.equals(person1.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
