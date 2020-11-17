package com.wmq.day01.demo;

public class Student {
    private String name;//姓名
    private int age;//年龄
    private boolean male;//性别

    public void setMale(boolean b){
        male =b;
    }
    public  boolean isMale(){
        return male;
    }

    public void setName(String str){
        name=str;
    }
    public String getName(){
        return name;
    }
    public void setAge(int num){
        age=num;
    }
    public int getAge(){
        return age;
    }


}
