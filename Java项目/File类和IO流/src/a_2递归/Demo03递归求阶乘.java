package a_2递归;

/*
 * 使用递归计算阶乘
 * n的阶乘:n!=n*(n-1)*....*3*2
 * */
public class Demo03递归求阶乘 {
    public static void main(String[] args) {
        long l = jc(50);
        System.out.println("l = " + l);
    }

    private static long jc(int n) {
        if (n == 1) {
            return 1;
        }

        return (n * jc(n - 1));
    }

}
