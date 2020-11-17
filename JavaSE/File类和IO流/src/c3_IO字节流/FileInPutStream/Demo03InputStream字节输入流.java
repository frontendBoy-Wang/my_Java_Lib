package c3_IO字节流.FileInPutStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
java.io.InputStream 抽象类是表示字节输入流的所有类的超类，可以读取字节信息到内存中。它定义了字节输入流的基本共性功能方法。
public void close()：关闭此输入流并释放与此流相关联的任何系统资源。
public abstract int read()： 从输入流读取数据的下一个字节。
public int read(byte[] b)： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

java, io,FileInputStream extends InputStream
FileInputStream:文件字节输入流
作用:把硬盘文件中的数据，读取到内存中使用
构造方法:
    FileInputStream(String name)
    FileInputStream(File file)
参数:读取文件的数据源
    string nome:文件的路径
    File file;文件
构造方法的作用:
    1.会创建一-个FileInputStream对象
    2.会把FileInputStream对象指定构造方法中要读取的文件
读取数据的原理硬盘-->内存)
    java程序--->05-->-5取职数据的方法-->读取文件
字节输入流的使用步骤(重点):
    1.创建FileInputStream对象,构造方法中绑定要读取的数据源
    2.使用FileInputStream对象中的方法read,读取文件
    3.释放资源


*/
public class Demo03InputStream字节输入流 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
        //2.使用FileInputStream对象中的方法read,读取文件
        //int read()读取文件中的一个字节并返回，读取到文件的末尾返回-1

        /*
        int len = fis.read();
        System.out.println("len = " + len);
        len = fis.read();
        System.out.println("len2 = " + len);
        */

        //循环读取
        int len=0;//记录读取到的字节
        while ((len=fis.read())!=-1){
            System.out.println("len = " + (char)len);
        }

        //释放资源关闭流
        fis.close();
    }
}
