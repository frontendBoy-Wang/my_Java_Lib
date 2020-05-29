package 排序;

import java.util.Random;

/**
 * 最近小值
 * 有功能NearestSmallerValue (ARR)中存储的整数
 * 数组ARR，对于列表中的每个元素，搜索所有前面的
 * 值，查找小于当前元素的最近元素,并根据这些数字创
 * 建一个新列表。如果在某个较小的位置之前没有元素,
 * 则输入-1。例如:如果ARR是[5, 2, 8, 3, 9, 12],
 * 那么最近的较小的数值列表是[-1, -1, 2, 2, 3, 9]。
 */

public class Search1 {

    public static int[] search(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] result = new int[arr.length];//查找后的数组

        result[0] = -1;//

        for (int i = 1; i < arr.length; i++) {
            int preValue = arr[i - 1];//当前元素的前一个元素的索引
            int curValue = arr[i];//当前元素的索引

            if (preValue < curValue) {
                //如果当前元素大于前一个元素,则把前一个元素放到新的数组
                result[i] = preValue;
            } else {
                //否则把-1放入新数组
                result[i] = result[i - 1];
            }
        }
        System.out.println("查找前:");
        for (int i : arr) {
            System.out.print(i + ",");
        }

        System.out.println("\n查找后:");
        for (int i : result) {
            System.out.print(i + ",");
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100)+1;
        }
        search(a);
    }

}



