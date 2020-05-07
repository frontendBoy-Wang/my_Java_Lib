package cn.课堂学习.异常处理;



import java.util.Scanner;

public class 自定义异常 extends Exception {
    public 自定义异常() {
    }

    public 自定义异常(String msg) {
        //主动去调用父类(Exception)的构造方法
        super(msg);
    }

    public static void main(String[] args) throws 自定义异常 {
        System.out.println("请输入一个整数!");
        Scanner scanner = new Scanner(System.in);
        try {
            int num = scanner.nextInt();
            System.out.println(num);
        } catch (Exception e) {
            throw new 自定义异常();
        }


    }
}
