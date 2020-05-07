package wmq.线程同步机制.ThreadSafe线程安全;
/*
模拟卖票案例
        创建3个线程,同时开启,对共享的票进行出售

解决线程安全问题的一种方案:使用同步代码块
        格式:
            synchronized(锁对象){
                可能会出现线程安全问题的代码(访问了共享数据的代码)
            }
        注意:
            1.通过代码块中的锁对象,可以使用任意的对象
            2.但是必须保证多个线程使用的锁对象是同一个
            3.锁对象作用:
              把同步代码块锁住,只让一个线程在同步代码块中执行

卖票案例出现了线程安全问题
        卖出了不存在的票和重复的票
        解决线程安全问题的二种方案:使用同步方法
        使用步骤:
        1.把访问了共享数据的代码抽取出来，放到一个方法中
        2.在方法上添加synchronized修饰符
        格式:定义方法的格式
        修饰符synchronized 返回值类型方法名(参数列表){
        可能会出现线程安全问题的代码(访问了共享数据的代码)
        }
*/


import java.util.Objects;

public class Ticket {
    public static void main(String[] args) {
        //创建runnable实现类对象
        RunnanbeImpl runnanbe = new RunnanbeImpl();
        System.out.println("runnanbe = " + runnanbe);
        Thread thread1 = new Thread(runnanbe);
        Thread thread2 = new Thread(runnanbe);
        Thread thread3 = new Thread(runnanbe);
        //调用start方法
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnanbeImpl implements Runnable {
    //定义一个多线程共享票源
    private static int ticket = 100;

    //创建一个锁对象
    Object obj = new Object();

    //设置线程任务:卖票
    @Override
    public void run() {
        System.out.println("this = " + this);
//使用死循环让卖票重复执行
        while (true) {
            //payTicket();
            payTicketStatic();//静态方法
        }
    }

//    定义一个同步方法
//    同步方法也会把方法内部的代码锁住
//    只让一个线程执行
//    同步方法的锁对象是谁?
//    就是实现类对象new RunnableImpl()
//    也是就是this

    public /*synchronized*/ void payTicket() {
//判断票是否存在
        synchronized (this) {
            if (ticket > 0) {
                //提高安全问题出现的概率,让程序睡眠
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //票存在,ticket--
                System.out.println(Thread.currentThread().getName() + "======>正在卖第" + ticket + "张票");
                ticket--;
            }
        }

    }

    /**********************************/
    /*
     *静态的同步方法
     *锁对象是谁?
     *不能是this
     *this是创建对象之后产生的，静态方法优先于对象
     *静态方法的锁对象是本类的cLass属性. ->class文件对象(反射)
     */
    public static synchronized void payTicketStatic() {
//判断票是否存在

        if (ticket > 0) {
            //提高安全问题出现的概率,让程序睡眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //票存在,ticket--
            System.out.println(Thread.currentThread().getName() + "======>正在卖第" + ticket + "张票");
            ticket--;
        }
    }

}



