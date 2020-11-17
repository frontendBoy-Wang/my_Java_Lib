package com.wmq.demo04数组;

import java.util.ArrayList;

/*
数组的长度不可以发生改变。
但是ArrayList集合的长度是可以随意变化的。

对于ArrayList来说，有一个尖括号<E>代表泛型。
泛型:也就是装在集合当中的所有元素，全都是统-的什么类型。
注意:泛型只能是引用类型，不能是基本类型。

注意事项:
对于ArrayList集合来说，直接打印得到的不是地址值，而是内容。
如果内容是空，得到的是空的中括号: []
*/
public class demo02ArrayList类 {
    public static void main(String[] args) {
        //创建了一个ArrayList集合，集合的名称是List, 里面装的全都是String字符串类型的数
        // 备往:从JDK 1.7+开始，右侧的尖括号内部可以不写内容，但是<>本身还是要写的。
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);//[]

        list.add("完美无缺");
        list.add("逆天而行");
        list.add("海阔天空");

        //list. add(100); //错误写法!因为创建的时候尖括号泛型已经说了是字符串，添加进去的元素就必须都是字符串才行

    }
}
