package cn.考试;

public class 运算相加 {
    public static void main(String[] args) {
//        声明四个整型变量a,b,c,d,
//        其初值自定义。编写程序输出表达式:a+b*c/d-5
        int a = 1, b = 2, c = 3, d = 4, sun = 0;
        sun = a + b * c / d - 5;
        System.out.println("表达式的值是：" + sun);//表达式的值是：-3
    }
}
