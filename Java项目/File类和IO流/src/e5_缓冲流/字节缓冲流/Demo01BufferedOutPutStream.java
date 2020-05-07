package e5_缓冲流.字节缓冲流;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
java. io. BufferedoutputStream extends OutputStream

        BufferedoutputStream:字节缓冲输出流
        继承自父类的共性成员方法:
        - public void close() :关闭此输出流并释放与此流相关联的任何系统资源。
public void flush() :刷新此输出流并强制任何缓冲的输出字节被写出。
public void write(byte[] b):将b. length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b, int off, int len) :从指定的字节数组写入len字节,从偏移量off开始输出到此输出流。
        一public abstract void write(int b) :将指定的字节输出流。
        构造方法:
        Buffered0utputStream(0utputStream out)创建- -个新的缓冲输出流，以将数据写入指定的底层输出流。
        BufferedoutputStreom(0utputStreom out, int size)创建- 一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输
        参数:
        OutputStream out :字节输出流
        我们可以传递File0utputStream,缓冲流会给File0utputStream增加一个缓冲区,提高FileOutputStream的写入效率
        int size:指定缓冲流内部缓冲区的大小,不指定默认
        使用步骤(重点)
        1.创建FileOutputStream对象,构造方法中绑定要输出的目的地
        2.创建BufferedoutputStream对象，构造方法中传递Fileoutputstream对象对象提高File0utputStream对象效率
        3.使用BufferedoutputStream对象中的方法write,把数据写入到内部缓冲区中
        4.使用BufferedoutputStream对象中的方法fLush,把内部缓冲区中的数据，刷新到文件中
        5.释放资源(会先调用flush方法刷新数据)
*/
public class Demo01BufferedOutPutStream {
    public static void main(String[] args) throws IOException {
           FileOutputStream fos=new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
           BufferedOutputStream bos=new BufferedOutputStream(fos);
           bos.write("写入".getBytes());
           bos.flush();
           bos.close();
    }


}
