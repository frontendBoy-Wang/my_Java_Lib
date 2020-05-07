package wmq.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
线程池:JDK1.5之后提供的
        java.util. concurrent.Executors :线程池的工厂类,用来生成线程池
        Executors类中的静态方法:
        static ExecutorService newF ixedThreadPool(int nThreads) 创建- -个可重用固定线程数的线程池
        参数:
        int nThreads :创建线程池中包含的线程数量
        返回值:
        ExecutorService接口,返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口接收(面向接口编程
        java.util.concurrent. ExecutorService:线程池接口
        用来从线程池中获取线程，调用start方法,执行线程任务
        submit(Runnable task) 提交- 一个Runnable 任务用于执行
        关闭/销毁线程池的方法
        void shutdown()
        线程池的使用步骤:
        1.使用线程池的工厂类Executors里边提供的确态方法newFixedThreadPool生产一个指定线程数量的线程池
        2.创建-一个类,实现Runnable接口，重写run方法,设置线程任务
        3.调用ExecutorsService中的方法submit,传递线程任务(实现类),开启线程执行run方法
        4.调用ExecutorService中的方法shutdown销毁线程池(不建议执行)

*/
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1.使用线程池的工厂类Executors里边提供的确态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es= Executors.newFixedThreadPool(2);

        //3.调用ExecutorsService中的方法submit,传递线程任务(实现类),开启线程执行run方法
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());

        es.shutdown();
        es.submit(new RunnableImpl());
    }

}



//2.创建-一个类,实现Runnable接口，重写run方法,设置线程任务
class RunnableImpl implements java.lang.Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程");
    }
}





































