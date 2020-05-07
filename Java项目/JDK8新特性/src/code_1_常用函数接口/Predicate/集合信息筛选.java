package code_1_常用函数接口.Predicate;

/*
练习:集合信息筛选
        数组当中有多条“姓名+性别”的信息如下，
        String[] array= {“迪丽热巴，女”，“古力娜扎,女”， “吗尔扎哈,男”， “赵丽颖,女” };
        请通过Predicate接口的拼装将符合要求的字符串筛选到集合Arraylist中，
        需要同时满足两个条件:
        1.必须为女姓;
        2.姓名为4个字。
        分析:
        1.有两个判断条件,所以需要使用两个Predicate接口,对条件进行判断
        2.必须同时满足两个条件,所以可以使用and方法连接两个判断条件
*/

import java.util.ArrayList;
import java.util.function.Predicate;

public class 集合信息筛选 {


    /* 定义一个方法
               方法的参数传递一一个包含人员信息的数组
       传递两个Predicate接口，用于对数组中的信息进行过滤
               把满足条件的信息存到Arraylist集合中并返回
   */
    private static ArrayList<String> fileter(String[] arr, Predicate<String> predicate1, Predicate<String> predicate2) {
        //定义一个ArrayList集合,存储过滤之后的信息
        ArrayList<String> list = new ArrayList<>();
        //遍历数组获取每一条信息
        for (String s : arr) {
            //使用Predicate接口中的方法test对获取到的字符串进行判断
            boolean b = predicate1.and(predicate2).test(s);
            //
            if (b) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //定义一个储存字符串的数组
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        //调用filter方法,传递字符串数组和两个Lambda表达式
        ArrayList<String> list = fileter(array, (String s) -> {
            //获取字符串中的性别,判断是否为女
            return s.split(",")[1].equals("女");
        }, (String s) -> {
            //获取字符串中的姓名,判断长度是否为4个字符
            return s.split(",")[0].length() == 4;
        });
        //遍历集合
        for (String s : list) {
            System.out.println(s);
        }
    }

}
