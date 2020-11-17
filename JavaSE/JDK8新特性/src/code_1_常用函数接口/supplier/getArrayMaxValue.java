package code_1_常用函数接口.supplier;

/*
练习:求数组元素最大值
        使用Suppl ier接口作为方法参数类型，通过lambda表达式求出int数组中的最大值。
        提示:接口的泛型请使用javo. lang. Integer类。
*/

import java.util.function.Supplier;

public class getArrayMaxValue {
    //定义一个方法，用于获取int类型数组中元素的最大值,方法的参数传递Supplier接口,泛型使用Integer
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) throws InterruptedException {
        long s = System.currentTimeMillis();
        //定义一个int数组并且赋值
        int[] arr = {1, 3, 4, 545, 67, 564};
        int max1 = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });

        System.out.println("数组中的最大值:" + max1);
        long e = System.currentTimeMillis();
        System.out.println(s/1000/60/60/24%365/24);
        System.out.println("耗时:" + (s - e));

    }
}
