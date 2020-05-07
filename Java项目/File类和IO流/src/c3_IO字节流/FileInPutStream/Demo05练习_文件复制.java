package c3_IO字节流.FileInPutStream;

/*
文件复制练习:一读一写
        明确:
        数据源: c:1\1.jpg
        数据的目的地: d:l\1.jpg
        文件复制的步骤:
        1.创建-一个字节输入流对象,构造方法中绑定要读取的数据源
        2.创建一个字节输出流对象，构造方法中绑定要写入的目的地
        3.使用字节输入流对象中的方法read读取文件
        4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
        5.释放资源
*/

import java.io.*;

public class Demo05练习_文件复制 {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        // 1.创建-一个字节输入流对象,构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("C:\\Users\\WMQ\\Desktop\\develop\\pic.png");
        //2.创建一个字节输出流对象，构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\copy\\pic.png");
        //3.使用字节输入流对象中的方法read读取文件

        /*int  len=0;
        while ((len=fis.read())!=-1){
            fos.write(len);
        }*/

        //效率高
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        //先关闭写的后关闭读取的,如果写完了肯定读完了
        fos.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println("程序共耗时:" + (s - e));
    }
}
