package wmq.Lambda表达式;

public class Demo01Runnable {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl runnable = new RunnableImpl();
        //创建Thread类对象,构造方法中传递Runnable接口的实现类
        Thread thread = new Thread(runnable);
        //调用start方法开启新线程.执行run方法
        thread.start();

        //简化代码,使用匿名内部类.实现多线程
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");

            }
        };
        new Thread(r).start();

        //简化代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
            }
        }).start();

        //优化省略
       new  Thread(()->System.out.println(Thread.currentThread().getName() + "创建了一个新的线程")).start();
    }
}

//创建Runnable接口的实现类,重写run方法.设置线程任务
class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
    }
}

