package wmq.线程的实现方式.Thread类的常用方法;

/*
public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停(暂时停止执行)。
        毫秒数结束之后,线程继续执行
*/

public class Thread类的常用方法_sleep暂停线程 {
    public static void main(String[] args) {
        sellp();
    }

    private static void sellp() {
        for (int i = 0; i <= 60; i++) {
            System.out.println("i = " + i);

            //使用Thread类的sleep方法让线程睡眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
