package com.wmq.demo01Scanner类;

import java.util.Scanner;//导包

/*
 * 引用类型的一般步骤：
 * 1：导包
 *  import包路径.类名称
 * 如果需要使用的目标类和当前类在同一个包下，则可以省略导包语句不写
 * 只要java.lang包下的内容不需要写导包语句其他的都要写import导包语句
 *
 * 2：创建
 *  类名称 对象名=new 类名称();
 *
 * 3:使用
 *   对象名.成员方法()
 *
 * 获取键盘输入的一个int数字：sc.nextInt();
 * 获取从键盘输入的一个字符串：String str=sc.next();
 */
public class demoScanner {

    public static void main(String[] args) {
//       2. 创建
//       备注：system.in代表从键盘输入
        Scanner sc = new Scanner(System.in);
//        3：获取从键盘输入的int数字
        System.out.println("请输入数字：");
        int num=sc.nextInt();
        System.out.println("输入的数字是:"+num);

        System.out.println("请输入字符：");
        String str=sc.next();
        System.out.println("输入的字符是:"+str);
    }
}






























