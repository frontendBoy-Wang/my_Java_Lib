package com.Collection集合;
/*
Debug调试程序:
可以让代码逐行执行,查看代码执行的过程,调试程序中出现的bug
使用方式:
在行号的右边,鼠标左键单击,添加断点(每个方法的第-行,哪里有bug添加到哪里)
右键，选择Debug执行程序
程序就会停留在添加的第一个断点处
执行程序:
f8:逐行执行程序
f7:进入到方法中
shift+f8:跳出方法
f9:跳到下一个断点,如果没有下一个断点,那么就结束程序
ctrl+f2 :退出debug模式，停止程序
Console:切换到控制台

 */
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    JDK9的新特性:
        List接口,Set接口,Mop接口:里边增加了一-个静态的方法of, 可以给集合一次性添加多个元素
        static <E> List<E> of (E... elements)
    使用前提:
        当集合中存储的元素的个数已经确定了,不在改变时使用
    注意:
        1.0f方法只适用于List接口,Set接口,Map接口,不适用于接接口的实现类
        2.0f方法的返回值是一个不能改变的集合,集合不能再使用add,put方法添加元素,会抛出异常
        3.Set接口和Mp接口在调用of方法的时候，不能有重复的元素,否则会抛出异常

 */
public class jdk9新特性 {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d");
        System.out.println(list);
        //list.add("d");//Exception in thread "main" java.lang.UnsupportedOperationException不支持操作异常

        Set<String> set = Set.of("a", "b", "c", "d");
        System.out.println(set);

        Map<String, String> map = Map.of("a", "b", "c", "d");
        System.out.println("map = " + map);
    }
}
