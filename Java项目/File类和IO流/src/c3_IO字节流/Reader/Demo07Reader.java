package c3_IO字节流.Reader;

/*
javo, io,Reader:字符输入流,是字符输入流的最顶层的父类,定义了一一些共性的成员方法，是一 一个抽象类
        共性的成员方法:
        int read() 读取单个字符并返回。
        int read(char[] cbuf)- -次读取多个字符，将字符读入数组。
        void close()关闭该流并释放与之关联的所有资源。
        java. io,FileReader extends InputStreomReader extends Reader
        FileReader:文件字符输入流
        作用:把硬盘文件中的数据以字符的方式读取到内存中
        构造方法:
        FileReader(String fileName)
        FileReader(File file)
        参数;读取文件的数据源
             String filename文件路径
       FileReader的构造方法的作用:
        1.创建一个FileReader对象
        2.会把FileReader对象指向要读取的文件

        字符输入流的使用步骤
        1.创建一个FileReader的对象
        2,使用对象中的read方法
*/

import java.io.FileReader;
import java.io.IOException;

public class Demo07Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
        /*int len=0;
        while ((len= fr.read())!=-1){
            System.out.print((char) len);
        }*/

        //int read(char[] cbuf)- -次读取多个字符将字符读入数组。
        char[] cs=new char[1024];//存储读取到的多个字符
        int len=0;
        while ((len= fr.read(cs))!=-1){
            /*
            string类的构造方法
            string(char[] value) 把字符数组转换为字符串
            String(chor[] value, int offset, int count)把字符数组的一部分转换为字符串offset数组的开始索引count转换的个数
            */
            System.out.print(new String(cs,0,len));
        }

        fr.close();
    }
}
