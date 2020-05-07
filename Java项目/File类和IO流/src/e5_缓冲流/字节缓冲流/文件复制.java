package e5_缓冲流.字节缓冲流;


/*
文件复制练习:一读一写
        明确:
        数据源: c:l\1.jpg
        数据的目的地: d:1\1.jpg
        文件复制的步骤:，
        1.创建字节缓冲输入流对象，构造方法中传递字节输入流
        2.创建字节缓冲输出流对象,构造方法中传递字节输出流
        3.使用字节缓冲输入流对象中的方法read,读取文件
        4.使用字节缓冲输出流中的方法write,把读取的数据写入到内部缓冲区中
        5.释放资源(会先把缓冲区中的数据，刷新到文件中)
*/

import java.io.*;

public class 文件复制 {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\WMQ\\Desktop\\develop\\pic.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\copy\\pic.png"));
        int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        bos.close();
        bis.close();
        long e = System.currentTimeMillis();
        System.out.println("耗时:" + (s - e) + "秒");


    }
}
