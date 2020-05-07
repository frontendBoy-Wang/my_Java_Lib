package code_4_方法引用;

public class DemoPrintable {
    //定义一个方法参数传递printable接口对字符串进行打印
    public static void printString(Printable p) {
        p.print("HelloWorld!");
    }

    public static void main(String[] args) {
        printString((String string) -> {
            System.out.println("string = " + string);
        });

        /*
        分析:
        Lambda表达式的目的，打印参数传递的字符串
        把参数s,传递给了system. out对象,调用out对象中的方法printLn对字符串进行了输出
        注意:
        1. System. out对象是已经存在的
        2.println方法也是已经存在的
        所以我们可以使用方法引用来优化L ambda表达式
        可以使用System. out方法直接引用(调用)println方法
        */

        printString(System.out::println);

    }
}
