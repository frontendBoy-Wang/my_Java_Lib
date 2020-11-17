package H_打印流;

/*
java. io.PrintStream:打印流
            PrintStream为其他输出流添加了功能，使它们前能够方便地打印各种数据值表示形式。
    PrintStream特点:
            1.只负责数据的输出,不负责数据的读取
            2.与其他输出流不同，PrintStream 永远不会抛出IOException
            3.有特有的方法，print, println
    void print(任意类型的值)
    void println(任意类型的值并换行)
    构造方法:
            PrintStream(File file):输出的目的地是一个文件
            PrintStream(OutputStream out) :输出的目的地是一一个字节输出流
            PrintStream(String fileName) :输出的目的地是一一个文件路径
            PrintStream extends OutputStream
    继承自父类的成员方法:
            public void close() ;关闭此输出流并程放与此流相关联的任何系统资源。
            public void flush() ; 刷新此输出流并强制任何缓冲的输出字节被写出。
            public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流。
            public void write(byte[]b, int off, int len) :从指定的字节数组写入len字节, 从偏移量off开始输出到此输出流。
            public abstract void write(int b) :将指定的字节输出流。|
注意;
        如果使用继承自父类的write方法写数据,那么查看数据的时候会查询编码表97->0
        如果使用自己特有的方法print/println方法写数据，写的数据原样输出97->97
*/

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("C:\\Users\\WMQ\\Desktop\\test\\print.txt");
        ps.write(97);
        ps.println(97);
        ps.close();
        demo();
    }

    private static void demo() throws FileNotFoundException {
        /*可以改变输出语句的目的地(打印流的流向)
        输出语句，默认在控制台输出
        使用system. setOut方法改变输出语句的目的地改为参数中传递的打印流的目的地
        static void setOut(PrintStream out)
        重新分配"标准*输出流。
        */
        System.out.println("我是在控制台输出的");

        PrintStream ps = new PrintStream("C:\\Users\\WMQ\\Desktop\\test\\目的地是.txt");
        System.out.println(ps);
        System.out.println("我在打印流的目的地中输出");
        ps.close();
    }
}
