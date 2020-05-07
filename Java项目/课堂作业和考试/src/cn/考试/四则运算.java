package cn.考试;

import java.util.Scanner;
/*
编写程序，给定两个整数及一个运算符(四则)， 根据运算符来判断该进行何种运算，
输出运算结果。例如， 运算符" +’是将两数相加。(忽视除数为0的情况)
*/

public class 四则运算 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个运算数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个运算数字：");
        int num2 = sc.nextInt();
        System.out.println("选择算法 '+','-','*','/','%%'");
        String str = sc.next();
        switch (str) {
            case "+":
                sum = num1 + num2;
                break;
            case "-":
                sum = num1 - num2;
                break;
            case "*":
                sum = num1 * num2;
                break;
            case "/":
                if (num2 > 0) sum = num1 / num2;
                break;
            case "%":
                if (num2 > 0) sum = num1 % num2;
                break;
        }
        System.out.println("运算结果是：" + sum);
    }
}