package code_1_常用函数接口.consumer;

/*
java.util.function.Consumer<T>接口则正好与Supplier接口相反，
        它不是生产-一个数据，而是消费一-个数据 ,其数据类型由泛型决定。
        Consumer接口中包含抽象方法void accept(T t),意为消费- -个指定泛型的数据。
        Consumer接口是一一个消费型接口,泛型执行什么类型,就可以使用accept方法消费什么类型的数据
        至于具体怎么消费(使用),需要自定义(输出,计算....
*/

import java.util.function.Consumer;

public class Demo01Consumer {
    /*
    定义一个方法
    方法的参数传递一个字符串的姓名
    方法的参数传递Consumer接口,泛型使用String
    可以使用Consumer接口消费字符串的姓名
    */
    private static void method1(String name, Consumer<String> con) {
    con.accept(name);
    }
    public static void main(String[] args) {
        //调用method方法,传递字符串姓名，方法的另-个参数是Consumer接口,是一一个函数式接口,所以可以传递Lamba表达式
        method1("汪满青",(String name)->{
            //使用传递的字符串
            //直接输出
            System.out.println("name = " + name);
            //使用方式,翻转输出

            String re=new StringBuilder(name).reverse().toString();
            System.out.println("re = " + re);
        });
    }


}
