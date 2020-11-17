package cn.课堂学习.异常处理;

public class Demo01 {
    public static void main(String args[]) {
        //1.try:尝试去执行有可能出现异常的语句块
        try {

            int a = 50;
            int result = a / 0;
        }
        //2. catch:捕获异常并处理
        catch (Exception e) {
            //默认e.printStackTrace();
            System.out.println("异常");
        }
        //3.无论是否出现异常最终都会有执行的语句坝
//        finally {
//            System.out.println("没有找到匹配的异常");
//        }
    }
}


