package code_1_常用函数接口.consumer;

/*
Consumer接口的默认方法andThen
        作用:需要两个consumer接口，可以把两个Consumer接口组合到一起,在对数据进行消费
        例如:
        Consumer<String> con1
        Consumer<String> con2
        String s = "hello";
        con1.accept(S);
        con2.accept($);
        连接两个Consumer接口再进行消费
        con1. andThen(con2).accept(s);谁写前边谁先消费
*/

import java.util.function.Consumer;

public class Demo02ConsumerAndThen {


    public static void main(String[] args) {
        show("wmq", (t) -> {
            System.out.println(t.toUpperCase());
        }, (t) -> {
            System.out.println(t.toLowerCase());
        });
    }

    private static void show(String s, Consumer<String> consumer1, Consumer<String> consumer2) {
        consumer1.accept(s);
        consumer2.accept(s);
        //使用andThen
        //使用andThen方法，把两个Consumer接口连接到一起,在消费数据
        consumer1.andThen(consumer2).accept(s);//con1连接con2,先执行con1消费数据，在执行con2消费数据


    }
}
