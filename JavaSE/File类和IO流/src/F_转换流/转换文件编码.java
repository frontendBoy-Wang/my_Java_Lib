package F_转换流;

/*
练习:转换文件编码
        将GBK编码的文本文件，转换为UTF- 8编码的文本文件。
        分析:
        1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称GBK
        2.创建OutputStreamlriter对象,构造方法中传递字节输出流和指定的编码表名称UTF-8
        3.使用InputStreamReader对象中的方法readi读取文件
        4.使用outputStreomlWriter对象中的方法write,把读取的数据写入到文件中
        5.释放资源
*/

import java.io.*;

public class 转换文件编码 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader
                (new FileInputStream("C:\\Users\\WMQ\\Desktop\\test\\我是GBK.txt"),"GBK");
        OutputStreamWriter osw=new OutputStreamWriter
                (new FileOutputStream("C:\\Users\\WMQ\\Desktop\\test\\我是UTF-8.txt"),"UTF-8");
        int len=0;
        while ((len=isr.read())!=-1){
            osw.write(len);
        }
        isr.close();
        osw.close();
    }
}
