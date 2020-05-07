package com.wmq.demo06String类;

/*
字符串的戴取方法:
public String substring(int index);截取从参数位置一直到字符串末尾返回新字符串。
public String substring(int begin, int end);截取从begin开始，-直到(end结束, 中间的字符串。

备往: [begin,end), 包含左边，不包含右边。
*/
public class 字符串的截取方法 {
    public static void main(String[] args) {
        String string1 = "HelloWorld";
        String string2 = string1.substring(5);
        System.out.println(string1);//HelloWorld,原封不动
        System.out.println(string2);//World,新字符串
        System.out.println("================");

        String string3=string1.substring(4,7);
        System.out.println(string3);//oWo

        String strA="Hello";

    }
}
