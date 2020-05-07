package com.wmq.demo06String类;

/*
java.lang.trig类关代表字符串。
API当中说: Java程序中的所有字符审宇面值(如"obc" )都作为此类的实例实现。
其实就是说:程序当中所有的双引号字符串,都是string类的对象。 (就算没有new, 也照样是。)
字符串的特点:
1.字符串的内容永不可变。 [重点]
2.正是因为字符事不可改变,所以字符串是可以共享使用的。
3.字符串效果上相当于是Char[]字符数组，但是底层原理是byte[ 存节数组。

创建字符的常见3+1种方式。
三种构造方法:
public String():创建一一个空白字符串， 不含有任何内容。
public String(char[] array);) 根据字符数组的内容，来创建对应的字符串。
public String(byte[] array);) 根据字节数组的内容,来创建对应的字符串。
一种直接创建: String str="Hello World";

注意：直接写上双引号，就是字符串对象。
*/
public class demo01String {
    public static void main(String[] args) {
        //使用空参数构造
        String str1 = new String();
        System.out.println("第1个字符串：" + str1);

        //根据字符数妇组创建字符串
        char[] chrray = {'A', 'B', 'C'};
        String str2 =new String(chrray);
        System.out.println("第2个字符串: " + str2);

        //根据字节数组创建字符串
        byte[] byteArray = {97, 98, 99};
        String str3 =new String(byteArray);
        System.out.println("第3个字符串: " + str3);
    }
}
