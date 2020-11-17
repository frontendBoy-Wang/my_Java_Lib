package com.wmq.demo06String类;

/*
String当中与获取相关的常用方法有:
public int length(); 获取字符串当中含有的字符个数，拿到字符串长度。
public String concat(String str);: 将当前字符串和参数字符串拼接成为迟回值新的字符串。
public char charAt(int index);获取指定索引位置的单个字符。(索引从开始。 )
public int indexOf(String str);: 查找参数字符串在本字符串当中首次出现的索引位置，如果没有返回.1值。
*/
public class 字符串获取相关的方法 {
    public static void main(String[] args) {
        //后去字符串的长度
        int length = "I Love 赵琴 forever".length();
        System.out.println(length);

        //拼接字符串concat
        String string="Hello";
        String string1="World";
        String string2=string.concat(string1);
        System.out.println(string);
        System.out.println(string1);
        System.out.println(string2);

        //获取指定索引位置的单个字符charAt
        char ch="Hello".charAt(1);
        System.out.println("在一号索引的位置的字符是："+ch);
        System.out.println("===========");

        //查找参数字符串的在本来的字符串中出现的第一次的索引位置
        //如果根本没有，返回-1值
        String string3="HelloWorld";
        int index=string3.indexOf("llo");
        System.out.println("第一次索引值是："+index);

        System.out.println("HelloWorld".indexOf("abc"));
    }
}















