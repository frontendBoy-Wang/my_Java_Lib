package com.wmq.demo01Scanner类;
import java.util.Scanner;//导包
/*
*题目：键盘输入两个数字，并且求和
*
* 思路：
* 1.键盘输入，需要用到Scanner类
* 2.Scanner的三个步骤：导包，创建，使用
* 3.需要两个数字，需要调用两次nextInt方法
* 4.得到两个数字相加的值，打印输出结果
*/
public class demo02ScannerSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入第一个数字：");
        int a=sc.nextInt();
        System.out.println("请输入第二个数字：");
        int b=sc.nextInt();

        int sum=a+b;
        System.out.println("结果是："+sum);
    }
}
