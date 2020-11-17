package code_1_常用函数接口.Predicate;

/*
逻辑表达式:可以连接多个判断的条件
        8&:与运算符,有false则|false
        11:或运算符,有true则true
        !:非(取反)运算符,非真则假,非假则真
        需求;判断一个字符串,有两个判断的条件
        1.判断字符串的长度是否大于5
        2.判断字符串中是否包含a
        两个条件必须同时满足，我们就可以使用88运算符连接两个条件
        Predicote接口中有一一个方法and, 表示并且关系，也可以用于连接两个判断条件
        defoult Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> this.test(t) 8&& other. test(t);
        方法内部的两个判断条件,也是使用88运算符连接起来的
*/

import java.util.function.Predicate;

public class Demo02Predicate_and {
    /* 定义一个方法,方法参数，传递一-个字符串
             传递两个Predicote接口
     一个用于判断字符串的长度是否大于5
             一个用于断字符串中是否包含
     两个条件必须同时满足*/
    public static boolean checkString(String s, Predicate<String> predicate1, Predicate<String> predicate2) {
        //return predicate1.test(s) && predicate2.test(s);
        return predicate1.and(predicate2).test(s);//等价return predicate1.test(s) && predicate2.test(s);

    }

    public static void main(String[] args) {
        String s = "ls";
        boolean b = checkString(s, (String str) -> {
            //判断字符串长度是否大于5
            return str.length() > 5;
        }, (String str) -> {
            //判断字符串是否包含a
            return str.contains("a");
        });
        System.out.println("b = " + b);
    }

}
