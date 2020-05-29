package 基础加强.junit;

/*
计算器类
 */
public class Demo01Junit {
    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
//        int i = 3 / 0;
        return a + b;
    }

    /**
     * 减法
     *
     * @param a
     * @param b
     * @return
     */
    public int sub(int a, int b) {
        return a - b;
    }

}

class test {
    public static void main(String[] args) {
        Demo01Junit demo01Junit = new Demo01Junit();
        int add = demo01Junit.add(1, 3);
        System.out.println("add = " + add);
        int sub = demo01Junit.sub(234, 2345);
        System.out.println("sub = " + sub);

        String string="abc";
        string.toUpperCase();
    }
}
