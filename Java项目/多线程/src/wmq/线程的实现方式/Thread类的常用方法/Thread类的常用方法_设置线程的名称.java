package wmq.线程的实现方式.Thread类的常用方法;

/*
设置线程的名称:(了解)
        1.使用Thread类中的方法setName(名字)
        void setNome(String name) 改变线程名称,使之与参数name 相同。
        2.创建一个带参数的构造方法,参数传递线程的名称;
          调用父类的带参构造方法，把线程名称传递给父类,让父类(Thread)给子线程起一个名字
          Thread(String name) 分配新的Thread 对象。
*/

public class Thread类的常用方法_设置线程的名称 {
    public static void main(String[] args) {
        //开启多线程
        MyThread3 myThread3=new MyThread3();
        myThread3.setName("小强");
        myThread3.start();

        //开启多线程
        new MyThread3("旺财").start();
    }
}

class MyThread3 extends Thread{
    public MyThread3(){}
    public MyThread3(String name){
        super(name);//调用父类的带参构造方法，把线程名称传递给父类,让父类(Thread)给子线程起一个名字
    }
    @Override
    public void run() {
        //获取线程的名称
        System.out.println(Thread.currentThread().getName());
    }
}
