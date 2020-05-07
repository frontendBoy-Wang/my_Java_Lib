package code_1_常用函数接口.Predicate;

/*
java. util.function. Predicate<T>接口
        作用:对某种数据类型的数据进行判断,结果返回一个booleam值
        Predicate接口中包含-一个抽象方法:
        boolean test(T t):用来对指定数据类型数据进行判断的方法
        结果:
        符合条件,返回true
        不符合条件,返回false
*/

import java.util.function.Predicate;

public class Demo01Predicate {
    public static void main(String[] args) {
        String s = "wmqasdf";
//        boolean b = show(s, (String str) -> {
//            return str.length() > 5;
//        });
        boolean b = show(s, (String str) -> str.length() > 5);
        System.out.println("b = " + b);
    }

    private static boolean show(String s, Predicate<String> predicate) {
        return predicate.test(s);

    }
}
