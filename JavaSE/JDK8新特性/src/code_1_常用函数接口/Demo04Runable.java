package code_1_常用函数接口;

public class Demo04Runable {
    public static void starThread(Runnable run){
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        starThread(new Runnable() {//匿名内部类
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"==>"+"线程启动了");
            }
        });
        //lambda表达式
        starThread(()->System.out.println(Thread.currentThread().getName()+"==>"+"线程启动了"));
    }
}
