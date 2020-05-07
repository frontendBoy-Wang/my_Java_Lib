package c3_IO字节流.Reader;

/*

java. io.Writer:字符输出流,是所有字符输出流的最项层的父类,是-一个抽象类
        共性的成员方法:
        void write(int c)写入单个字符。
        void write(char[] cbuf)写入字符数组。
        abstract void write(char[] cbuf, int off, int len)写入字符数组的某一部分， of数组的开始索引，len写的字符个数。
        void write(String str)写入字符串。
        void write(String str, int off, int len)写入字符串的某-部分, of字符串的开始索引, len写的字符个数。
        void flush()刷新该流的缓冲。
        void close() 关闭此流，但要先刷新它。

java. io,FileWriter extends OutPutStreamWriter extends Writer
FilWriter:文件字符输出流
        作用:把内存中字符数据写入到文件中
        构造方法:
            FileWriter(File file)根据给定的File 对象构造- -个FileWriter 对象。
            FileWriter(string fileName) 根据给定的文件名构造-一个 FileWriter 对象。
        参数:写入数据的目的地
            String fileNome;文件的路径
            File file:是- -个文件
        构造方法的作用:
            1.会创建一-个FileWriter对象
            2.会根据构造方法中传递的文件/文件的路径,创建文件
            3.会把FileWriter对象指向创建好的文件

字符输出流的使用步骤(重点):
        1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
        2.使用FileWriter中的方法write,把数据写入到内存缓冲区中(字符转换为字节的过程)
        3.使用FileWriter中的方法flush,把内存缓冲区中的数据,刷新到文件中
        4.释放资源(会先把内存缓冲区中的数据刷到文件中)

flush方法和close方法的区别
        flush：刷新缓冲区，流对象可以继续使用。
        close:先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

*/

import java.io.FileWriter;
import java.io.IOException;

public class Demo08Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\WMQ\\Desktop\\develop\\b.txt");
        fw.write(86);
        fw.flush();
        fw.write(50);
        fw.close();
    }
}
