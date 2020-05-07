package G_序列化;


/*
java. io. objectoutputstream extends outputStream
        objectoutputstream :对象的序列化流
        作用:把对象以流的方式写入到文件中保存
        构造方法:
        objectoutputStream(outputStream out)创建写入指定outputstream的objec toutputstream。
        参数:
        outputstream out :字节输出流
        特有的成员方法:
        void writeobject(object obj) 将指定的对象写入objectoutputStream。
        使用步骤:
        1.创建bjectoutputstream对象,构造方法中传递字节输出流
        2.使用objectoutputstream对象中的方法writeObject,把对象写入到文件中
        3.释放资源
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\WMQ\\Desktop\\test\\person.txt"));
        oos.writeObject(new Person("赵琴小可爱", 19));
        oos.close();
    }
}


/*
序列化和反序列化的时候,会抛出NotSerial izableException没有序列化异常
        类通过实现java. io. Serializoble接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
        Serializable接口也叫标记型接口
        要进行序列化和反序列化的类必须实现Serial izable接口，就会给类添加一个标记
        当我们进行序列化和反序列化的时候，就会检测类上是否有这个标记
        有:就可以序列化和反序列化
        没有:就会抛出NotSerial izableException异常
        去市场买肉-->肉上有一-个蓝色章(检测合格)-- >放心购买-- >买回来怎么吃随意

static关键字:静态关键字
        静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
        被static修饰的成员变量不能被序列化的，序列化的都是对象
private static int age;
        oos. writeobject(new Person( “小美女”, 18));
        object。= ois. readobject(); .
        Person{name=‘小美女'，age=0}
        transient关键字:瞬态关键字
        被transient修饰成员变量,不能被序列化I
private transient int age;
        oos . writeObject(new Person(“小美女”, 18));
        object。= ois. readobject();
        Person{name=“小美女’，age=0|

*/

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    //private static int age;
    //private transient int age;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}