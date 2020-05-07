package wmq.等待唤醒机制案例;

/*消费者(吃货)类:是-一个线程类,可以继承Thread
        设置线程任务(run) :吃包子
        对包子的状态进行判断
        false:没有包子
        吃货调用wait方法进入等待状态
        true:有包子
        吃货吃包子
        吃货吃完包子
        修改包子的状态为false没有
        吃货唤醒包子铺线程,生产包子*/
public class ChiHuo extends Thread {
    //1.在成员位置这是一个包子变量
    private BaoZi bz;

    //2.使用带参数的构造方法.维包子变量负值

    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.flag = false) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后执行的代码.吃包子
                System.out.println("吃货正在吃包子:" + bz.pi + bz.xian + "的包子");
                //吃货吃完包子
                //修改包子的状态为false没有
                bz.flag = false;
                //吃货唤醒包子铺的线程,生产包子
                bz.notify();
                System.out.println("吃货已经把:" + bz.pi + bz.xian + "的包子吃完了,包子铺开始生产包子");
                System.out.println("**************************************");
            }
        }
    }
}
