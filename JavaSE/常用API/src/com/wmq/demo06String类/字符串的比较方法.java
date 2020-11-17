package com.wmq.demo06String类;

/*
==是进行对象的地址值比较, 如果确实需要字符串的内容比较，可以使用两个方法:
public boolean equals(object obj);参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true;否则返回false。

注意事项:
1.任何对象都能用Object进行接收。
2.equals方法具有对称性,也就是a.equals(b)和b.equals(o)效果一样。
3.如果比较双方是一个常量一个变量，推荐把常量字符串写在前面。
推荐: "bc".equals(str) 不推荐: str.equals("bc")

public boolean equalsIgnoreCase(String str);: 忽略大小写,进行内容比较。
*/
public class 字符串的比较方法 {
    public static void main(String[] args) {
        String str1="Hello";
        String str2="Hello";
        char[] charArray={'H','e','l','l','o'};
        String str3=new String(charArray);

        System.out.println(str1.equals(str2));    //true
        System.out.println(str2.equals(str3));//true
        System.out.println(str3.equals("Hello"));//true
        System.out.println("Hello".equals(str1));//true

        String str4="hello";
        System.out.println(str1.equals(str4));//false
        System.out.println("=========================");

        String str5=null;
        System.out.println("abc".equals(str5));//推荐，false

        String strA="Java";
        String strB="java";
        System.out.println(strA.equals(strB));//false 严格区分大小写
        System.out.println(strA.equalsIgnoreCase(strB));//true 忽略大小写

        //注意只有英文字母区分大小写，其他都不区分大小写
        System.out.println("abc一123".equalsIgnoreCase("abc壹123"));//false


    }

}
