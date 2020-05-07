package cn.考试;

import java.util.Arrays;

public class 数组排序输出最大值和最小值 {

    public static void main(String[] args) {
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 100 + 100);
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+",");
        }
        
        System.out.println();
        System.out.println("最大值:" + num[9]);
        System.out.println("最小值:" + num[0]);
    }
}
