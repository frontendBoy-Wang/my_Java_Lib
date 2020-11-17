package com.wmq.demo03Random随机类;

import java.util.Random;

/*
* 题目：
* 根据int变量n的值，来获取随机数字，范围是[1,n]，可以取到1地可以取到n。
*
* */
public class demo03Random {
    public static void main(String[] args) {
        int n=5;
        Random r=new Random();
        for (int i = 0; i < 100; i++) {
            //原来的范围是[0,1),整体+1之后就变成了[1,n+1),也就是[1,n]
            int result=r.nextInt(n)+1;
            System.out.println(result);
        }

    }

}
