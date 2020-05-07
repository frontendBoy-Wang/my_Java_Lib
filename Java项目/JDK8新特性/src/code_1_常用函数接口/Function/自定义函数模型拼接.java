package code_1_常用函数接口.Function;

/*题目请使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
        String str="赵丽颖,20";
        分析:
            1.将字符串截取数字年龄部分,得到字符串;
            Function<String, String>“赵丽颖, 20"->"20"
            2.将上一步的字符串转换成为int类型的数字;
            Function<String, Integer> "20"->20
            3.将上一步的int数字累加100,得到结果int数字。
            Function<Integer, Integer> 20->120
*/

import java.util.function.Function;

public class 自定义函数模型拼接 {
    public static int change(String s,
                             Function<String, String> function1,
                             Function<String, Integer> function2,
                             Function<Integer, Integer> function3) {
        return function1.andThen(function2).andThen(function3).apply(s);
    }

    public static void main(String[] args) {
        String str = "汪满青,20";
        int num = change(str, (String s) -> {
            return s.split(",")[1];
        }, (String s) -> {
            return Integer.parseInt(s);
        }, (Integer i) -> {
            return i + 100;
        });
        System.out.println("num = " + num);
    }
}
