package cn.作业;

//1.(40分问答题 编写程序,给定一 个整数，判断它是否能同时被2和3整除，输出判断结果。

import java.util.Scanner;

public class 能否被2和是3整除 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int a = sc.nextInt();
        if (a % 2 == 0 && a % 3 == 0) {
            System.out.println("这数能同时被2和3整除");
        } else {
            System.out.println("不能能同时被2和3整除");
        }
    }
}
