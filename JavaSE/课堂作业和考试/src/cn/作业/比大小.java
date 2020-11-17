package cn.作业;

import java.util.Scanner;

//2. (60分问答题编写程序， 比较三个整型变量xy,z的大小，并按照由小到大的次序输出。
public class 比大小 {
    public static void main(String[] args) {
        int x = 0, y = 0, z = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个整数：");
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        int j;
        if (x > y) {
            j = y;
            y = x;
            x = j;
        }
        if (x > z) {
            j = z;
            z = x;
            x = j;
        }
        if (y > z) {
            j = z;
            z = y;
            y = j;
        }
        System.out.println(x + " " + y + " " + z);
    }
}
