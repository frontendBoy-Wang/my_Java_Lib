package c3_IO字节流.FileOutPutStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;//字节输出流,表示输出字节流的所有类的超类
import java.util.Arrays;
/*
public void close()关闭此输出流并释放与此流相关联的任何系统资源。
public void flush() 刷新此输出流并强制任何缓冲的输出字节被写出。
public void write(byte[] b)将 b.length字节从指定的字节数组写入此输出流。
public void write(byte[] b, int off, int len)从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
public abstract void write(int b)将指定的字节写入此输出流。

    java, io.FileOutputStream extends 0utPutStream
    FileOutputStream:文件字节输出流
                作用:把内存中的数据写入到硬盘的文件中

构造方法:
    FileOutputStream(String name )创建-一个向具有指定名称的文件中写入数据的输出文件流。
    FileOutputStream(File file) 创建-一个向指定 File 对象表示的文件中写入数据的文件输出流。
    参数:写入数据的目的
    string nome:目的地是一一个文件的路径
    File file:目的地是一一个文件
构造方法的作用:
    1.创建一-个File0utPutStream对象
    2.会根据构造方法中传递的文件/文件路径,创建一一个空的文件
    3.会把FileOutputStream对象指向创建好的文件

写入数据的原理:(内存---->硬盘)
    Java程序--->JVM(Java虚拟机)--->OS(操作系统)调用写数据的方法--->数据的目的地

字节输出流的使用步骤:
    1.创建一个FileOutPutStream对象,构造方法中传递写入数据的路径
    2.调用FileOutPutStream对象中的方法write()把数据写入到文件中
    3.释放资源(流的使用会占用一定的内存,使用完需要释放内存,提高程序的效率)

*/

public class Demo01OutPutStream {
    public static void main(String[] args) throws IOException {

        //1.创建一个FileOutPutStream对象,构造方法中传递写入数据的路径
        FileOutputStream fos = new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
        //2.调用FileOutPutStream对象中的方法write()把数据写入到文件中
        fos.write(97);
        //3.释放资源(流的使用会占用一定的内存,使用完需要释放内存,提高程序的效率)
        // fileOutputStream.close();

            /*
           public void write(byte[] b): 将b. length字节从指定的字节数组写入此输出流。
            -次写多个字节:
            如果写的第一个字节是正数(0-127),，那么显示的时候会查询ASCII表
            如果写的第一个字节是负数，那第一一个字节会和第二个字节,两个字节组成一个中文显示,查询系统默认码表(GBK)
            */
        byte[] bytes = {65, 66, 67, 68};
        fos.write(bytes);

        /*
       public void write(byte[] b, int off, int len) : 把字节数组的一部分写入到文件中
        从指定的字节数组写入len字节,从偏移量off开始输出到此输出流。
        int off:数组的开始索引
        int len :写入几个字节
        */
        fos.write(bytes, 1, 2);

        /*
        一次写多个字节
        写入字符串的方法:
        String类中的getBytes() 把字符串转换为字节数组
         */
        byte[] bytes1="你好".getBytes();
        System.out.println(Arrays.toString(bytes1));//[-28, -67, -96, -27, -91, -67]
        fos.write(bytes1);


        //释放资源,关闭流
        fos.close();
    }
}
