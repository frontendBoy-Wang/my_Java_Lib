package wmq.等待唤醒机制案例;
/*
分析:需要哪些类
资源类:包子类
设置包子的属性:皮,陷
包子的状态:有true,没有false
 生产者(包子铺)类:是一个线程类,可以继承Ihread
     设置线程任务(run):生产包子
     对包子的状态进行判断
     true:有包子
          包子铺调用wait方法进入等待状态
     false:没有包子
           包子铺生产包子
           增加一些趣味性:交替生产两种包子
           有两种状态(1号2==0)
           包子铺生产好了包子
           修改包子的状态为true有
           唤醒吃货线程,让吃货线程吃包子
 消费者(吃货)类:是-一个线程类,可以继承Thread
           设置线程任务(run) :吃包子
           对包子的状态进行判断
           false:没有包子
           吃货调用wait方法进入等待状态
           true:有包子
           吃货吃包子
           吃货吃完包子
           修改包子的状态为false没有
           吃货唤醒包子铺线程,生产包子
 测试类:
 包含main方法，程序执行的入口,启动程序
 创建包子对象;
 创建包子铺线程,开启,生产包子;
 创建吃货线程,开启，吃包子;
*/

/*注意:
        包子铺线程和包子线程关系->)通信(互斥)
        必须同时同步技术保证两个线程只能有一一个在执行
        锁对象必须保证唯一,可以使用包子对象作为锁对象
        包子铺类和吃货的类就需要把包子对象作为参数传递进来
        1.需要在成员位置创建一一个包子变量
        2.使用带参数构造方法，为这个包子变量赋值
        */


public class BaoZiPu extends Thread {
    //1.需要在成员位置创建一一个包子变量
    private BaoZi bz;

    //2.使用带参数构造方法，为这个包子变量赋值

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }


    //设置线程任务run:生产包子
    @Override
    public void run() {
        //定义一个变量
        int count = 0;
        while (true) {
            //必须同时同步技术保证两个线程只能有一一个在执行
            synchronized (bz) {
                //如果有包子
                if (bz.flag == true) {
                    //包子铺调用wait方法进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后执行,包子铺生产包子
                //增加一些趣味性,交替生产包子
                if (count % 2 == 0) {
                    //生产薄皮包子
                    bz.pi = "薄皮";
                    bz.xian = "三鲜馅";
                } else {
                    //生产冰皮包子
                    bz.pi = "冰皮";
                    bz.xian = "牛肉大葱";
                }
                count++;
                System.out.println("包子铺正在生产:" + bz.pi + bz.xian + "包子");

                //生产包子要三秒
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //包子铺生产好了包子
                //修改包子的状态为true
                bz.flag = true;
                //唤醒吃货线程,让吃货线程吃包子
                bz.notify();
                System.out.println("包子铺已经生产好了" + bz.pi + bz.xian + "包子,吃货可以开始吃了");
            }
        }
    }
}
