package e5_缓冲流.字符缓冲流;

/*
java. io. Bufferedwriter extends Writer
        Bufferedwriter :字符缓冲输出流
        继承自父类的共性成员方法:
         void write(int c)写入单个字符。
         void write(char[] cbuf)写入字符数组。
         abstract void write(char[] cbuf, int off, int len)写入字符数组的某-部分, f数组的开始索引，Len写的字符个数。
         void write(string str)写入字符串。
         void write(String str, int off, int len) 写入字符串的某一 部分，off字符串的开始索引，len写的字符个数。
         void flush()刷亲新该流的缓冲。
         void close()关闭此流,但要先刷新它。
    构造方法:
        Bufferedwriter(Writer out)创建- 一个使用默认大小输出缓冲区的缓冲字符输出流。
        Bufferedwriter(writer out, int s2)创建一一个使用给定大小输出缓冲区的新缓冲字符输出流。
    参数:
        Writer. out :字符输出流
        我们可以传递FileWriter,缓冲流会给FilelWriter增加一个缓冲区，提高FilelWriter的写入效率
        int sz:指定缓冲区的大小,不写默认大小
    特有的成员方法:
        void newline()写入一个行分隔符。会根据不同的操作系统,获取不同的行分隔符
    换行:换行符号
        windows:/r/n
        linux:/n
        mac:/r
    使用步骤:
        1.创建字符缓冲输出流对象.构造方法中传递字符输出流
        2.调用字符缓冲输出流中的方法write,把数据写入到内存缓冲区中
        3.调用字符缓冲输出流中的方法flush,把内存缓冲区中的数据，刷新到文件中
        4.释放咨源


*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo01BufferedWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\WMQ\\Desktop\\develop\\a.txt"));
        for (int i = 0; i < 10; i++) {
            bw.write("程序员");
            //bw.write("\r\t");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
