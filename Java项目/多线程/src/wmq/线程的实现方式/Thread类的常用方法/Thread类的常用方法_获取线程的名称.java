package wmq.线程的实现方式.Thread类的常用方法;

/*
获职线程的名称:
        1.使用Thread类中的方法getName()
        String getNome() 返回该线程的名称。
        2.可以先获取到当前正在执行的线程,使用线程中的方法getNome( )获取线程的名称
static Thread currentThread() 返回对当前正在执行的线程对象的引用。
*/
/*
 * 线程的名称:
 *       主线程:main
 *       新线程:Thread-0,Thread-1...*/
public class Thread类的常用方法_获取线程的名称 {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread2 myThread2 = new MyThread2();
        //调用start方法,开启新线程,执行run方法
        myThread2.start();

        new MyThread2().start();
        new MyThread2().start();

        //链式编程
        System.out.println(Thread.currentThread().getName());

    }
}

//定义一个Thread子类
class MyThread2 extends Thread {
    //重写Thread子类中的run方法,设置线程任务

    @Override
    public void run() {
        //获取线程名称
        //String name=getName();
        //System.out.println(name);

        //Thread t=Thread.currentThread();
        //System.out.println(t);//Thread[Thread-0,5,main]
        //String name=t.getName();
        //System.out.println(name);

        //链式编程
        System.out.println(Thread.currentThread().getName());
    }
}
