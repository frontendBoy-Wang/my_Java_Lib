package com.wmq.demo03Random随机类;

import java.util.Random;

/*
 * 1:导包
 *   import java.util.Random;
 *
 * 2：创建
 *   Random r=new Random();
 *
 * 3:使用
 *   获取一个随机的int数字(范围是int所有，有正负两种)
 *   int num=r.nextInt();
 *   获取一个随机的int数字(参数范围是左闭右开区间)
 *   int num=r.next(3);
 * 实际上代表的含义是：[0,3],也就是0~2
 */
public class demo01Random {
    public static void main(String[] args) {
        Random r = new Random();

        int num = r.nextInt();
        System.out.println(num);
    }
}
