package c3_IO字节流.FileInPutStream;
/*
字节输入流一次读取多个字节的方法:
        int read(byte[] b)从输入流中读取-一定数量的字节,并将其存储在缓冲区数组b中。
        明确两件事情:
        1.方法的参数byte[]的作用?
        起到缓冲作用，存储每次读取到的多个字节
        数组的长度-把定义为1024(1kb )或者1024的整数倍
        2.方法的返回值int是什么?
        每次读取的有效字节个数
        string类的构造方法
        String(byte[] bytes) :把字节数组转换为字符串
        String(byte[] bytes, int offset, int length) 把字节数组的一部分转换为字符串offset ;数组的开始索引length:转换的字节个数
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Demo04字节输入流一次读取多个字节 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
       /* byte[] bytes = new byte[2];
        int len = fis.read(bytes);
        System.out.println("len = " + len);
        System.out.println(new String(bytes));
        System.out.println("==================");*/
        //循环读取
        byte[] bytes1=new byte[1024];int len;
        while ((len=fis.read(bytes1))!=-1){
            System.out.println(new  String(bytes1,0,len));
        }
        fis.close();
    }
}
