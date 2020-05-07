package wmq.线程的实现方式.匿名内部类创建线程;

public class Demo01InnerClassThread {
    public static void main(String[] args) {
        //线程的父类Thread
        //new MyThread().start()
        new Thread() {
            //重写run方法,设置主线程任务
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "=====>" + i);
                }
            }
        }.start();

        //线程的接口Runable接口
        //Runable r=new Runable
        Runnable r = new Runnable() {
            //重写run方法,设置线程任务
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "=====>" + "wmq");
                }
            }
        };
        new Thread(r).start();

        //简化接口的方式
        new Thread(new Runnable() {
            //重写run方法,设置线程任务
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "=====>" + "wmq2");
                }
            }
        }).start();
    }
}
