package wmq.线程的实现方式;
/*
主线程:执行主(main)方法的线程
        单线程程序:java程序中只有一-个线程
        执行从main方法开始,从上到下依次执行
        JVN执行main方法，main方法会进入到栈内存
        JVM会找操作系统开辟一条main方法通向cpu的执行路径
        Cpu就可以通过这个路径来执行main方法
        而这个路径有一个名字，叫main(主)线程
*/

public class Demo01MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("小强");
        p1.run();
        System.out.println(0/0);//单线程的弊端.当主线程发生异常,就无法执行后面的线程
        Person p2 = new Person("旺财");
        p2.run();
    }
}
class Person {
    private String name;

    public void run(){
        //定义循环执行20次
        for (int i=0;i<20;i++){
            System.out.println(name+"------>"+i);
        }
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
