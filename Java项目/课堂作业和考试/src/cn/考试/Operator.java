package cn.考试;

/*
编写程序定义类Operator。声明整型变量a，
使用”+=”运算符使a自增10;定义整型变量b，
使其自增1; 定义整型变量c,使其自减1。
输出a,b,c的值。
 */
public class Operator {
    public static void main(String[] args) {
        int a = 0;
        a += 10;
        int b = 0;
        b++;
        int c = 2;
        c--;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
