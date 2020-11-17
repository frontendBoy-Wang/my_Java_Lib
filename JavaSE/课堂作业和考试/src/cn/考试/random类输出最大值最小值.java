package cn.考试;

import java.util.Arrays;
import java.util.Random;

/*
使用Math.random(方法产生10个100 ~ 200之间的随机整数，
输出其中的最大值和最小值。
 */
public class random类输出最大值最小值 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int num = random.nextInt(100) + 100;
            array[i] = num;
            System.out.print(array[i]+"\t");
        }

        System.out.println();
        int max = array[0];
        for (int i = 1; i < array.length; i++) {

            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("最大值" + max);

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("最小值" + min);
    }
}
