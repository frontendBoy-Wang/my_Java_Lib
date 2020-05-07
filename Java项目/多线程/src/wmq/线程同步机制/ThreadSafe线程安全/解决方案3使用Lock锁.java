package wmq.线程同步机制.ThreadSafe线程安全;
/*
卖票案例出现了线程安全问题
        卖出了不存在的票和重复的票
        解决线程安全问题的三种方案:使用Lock锁
        java.util.concurrent.locks.Lock接口
        Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作。
        Lock接口中的方法:
        void lock( )获职锁。
        void unlock()释放锁。
        java.util. concurrent. locks . ReentrantLock implements Lock接口
        使用步骤: .
        1.在成员位置创建-个ReentrantLock对象
        2.在可能会出现安全问题的代码前调用Lock接口中的方法lock获职锁
        3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 解决方案3使用Lock锁 {
    public static void main(String[] args) {
        //创建runnable实现类对象
        RunnanbeImpl3 run = new RunnanbeImpl3();

        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);
        Thread thread3 = new Thread(run);
        //调用start方法
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnanbeImpl3 implements Runnable {
    //定义一个多线程共享票源
    private static int ticket = 100;

    //1.在成员位置创建-个ReentrantLock对象
    Lock lock = new ReentrantLock();

    //设置线程任务:卖票
    @Override
    public void run() {
        System.out.println("this = " + this);
        //使用死循环让卖票重复执行
        while (true) {
            //2.在可能会出现安全问题的代码前调用Lock接口中的方法lock获职锁
            lock.lock();
            if (ticket > 0) {
                //提高安全问题出现的概率,让程序睡眠
                try {
                    Thread.sleep(1);
                    //票存在,ticket--
                    System.out.println(Thread.currentThread().getName() + "======>正在卖第" + ticket + "张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
                    lock.unlock();//无论程序是否异常，都会把锁释放
                }
            }
        }
    }
}
