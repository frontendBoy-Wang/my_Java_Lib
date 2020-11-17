package F_转换流;

/*
java. io.0utPutStreamWriter extends Writer
        0utPutStreamWriter:是字符流通向字节流的桥梁:可使用指定的charset 将要写入流中的字符编码成字节。(编码把能看懂的变成看不懂)
        继续自父类的共性成员方法:
             void write(int ()写入单个字符。
             void write(char[] cbuf)写入字符数组。
             abstract void write(char[] cbuf, int off, int len)写入字符数组的某一部分，of数组的开始索引，len写的字符个数。
             void write(String str)写入字符串。
             void write(String str, int off, int len)写入字符串的某-一部分, of字符串的开始索引, len写的字符个数。
             void flush()刷新该流的缓冲。
             void Close()关闭此流，但要先刷新它。
        构造方法:
            OutputStreamWriter(0utPutStream out )创建使用默认字符编码的OutputStreamlriter。
            OutputStreamWriter(OutputStream out, String charsetNome)创建使用指定字符集的0utputStreamliriter。
        参数:
            OutputStream out:字节输出流可以用来写转换之后的字节到文件中
            String charsetNome :指定的编码表名称,不区分大小写,可以是utf- 8/UTF - 8, gbk/GBK,.. .不指定默认使用UTF-8
       使用步骤:
        1.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称
        2.使用OutputStreamWriter对象中的方法write,把字符转换为字节存储缓中区中(编码)
        3.使用OutputStreamWriter对象中的方法flush,把内存缓冲区中的字节刷新到文件中(使用字节流写字节的过程)
        4.释放资源
*/


import java.io.*;

public class Demo01OutPutStreamWrite {
    public static void main(String[] args) throws IOException {
        //write_utf_8();
        write_GBK();
    }

    private static void write_GBK() throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter
            (new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\gbk.txt"),"GBK");
        osw.write("你好");
        osw.flush();
        osw.close();
    }


    private static void write_utf_8() throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter
                (new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\gbk.txt"),"utf-8");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
