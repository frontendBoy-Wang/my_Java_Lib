package code_1_常用函数接口.supplier;

import java.util.function.Supplier;

/*
常用的函数式接口
java.util.function. Supplier<T>接口仅包含- 个无参的方法: T get()o用来获取-个泛型参数指定类型的对象数据。
Supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型,那么接口中的et方法就会生产什么类型的数据

 */
public class Demo01supplier {
    public static void main(String[] args) {
        String s = getString(() -> {
            return "Hello";
        });
        System.out.println(s);
        //优化之后的Lambda表达式
        String s2 = getString(() -> "Hello");
        System.out.println(s);
    }

    private static String getString(Supplier<String> sup) {

        return sup.get();
    }

}
