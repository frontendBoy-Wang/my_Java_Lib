package G_序列化;

/*
练习:序列化集合
            当我们想在文件中保存多个对象的时候
            可以把多个对象存储到一个集合中
            对集合进序列化和反序列化
        分析:
            1.定义-一个存储Person对象的ArrayList集合
            2.往ArrayList集合中存储Person对象
            3.创建-一个序列化流ObjectOutputStream对象
            4.使用ObjectOutputStream对象中的方法WriteObject,对集合进行序列化
            5.创建一一个反序列化objectInputStream对象
            6.使用object InputStream对象中的方法readObject读取文件中保存的集合
            7.把object类型的集合转换为ArrayList类型
            8.遍历ArrayList集合
            9.释放资源
*/

import java.io.*;
import java.util.ArrayList;

public class Demo03Test序列化集合 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义-一个存储Person对象的ArrayList集合
        ArrayList<Person> list = new ArrayList<>();
        //2.往ArrayList集合中存储Person对象
        list.add(new Person("张三", 18));
        list.add(new Person("李四", 19));
        list.add(new Person("王五", 20));
        list.add(new Person("赵六", 22));
        // 3.创建-一个序列化流ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\WMQ\\Desktop\\test\\list.txt"));
        //4.使用ObjectOutputStream对象中的方法WriteObject,对集合进行序列化
        oos.writeObject(list);
        //5.创建一一个反序列化objectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\WMQ\\Desktop\\test\\list.txt"));
        // 6.使用object InputStream对象中的方法readObject读取文件中保存的集合
        Object o = ois.readObject();
        //7.把object类型的集合转换为ArrayList类型
        ArrayList<Person> list2 = (ArrayList<Person>) o;
        // 8.遍历ArrayList集合
        for (Person person : list2) {
            System.out.println(person);
        }
        // 9.释放资源
        ois.close();
        oos.close();
    }
}
