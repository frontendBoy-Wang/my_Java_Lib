package com.wmq.封装;

/*
 * 方法就是一种封装
 * 关键字private也是一种封装
 * 封装就是对一些细节信息隐藏起来，对于外界不可用
 * 关键字private也是一种封装
 * private：用于将需要保护的成员变量进行修饰
 * 一旦使用private进行修饰。那么本类中可以随意访问
 * 但是超出了本类的范围就不能直接访问了
 */
public class 封装 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30};

        int max = grtMax(array);
        System.out.println("最大值"+max);

    }

    public static int grtMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
