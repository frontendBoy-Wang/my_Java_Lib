package e5_缓冲流.字符缓冲流;

/*
java, io. BufferedReader extends Reader
        继承自父类的共性成员方法:
        int read() 读取单个字符并返回。
        int read(char[] cbuf)- -次读取多个字符,将字符读入数组。
        void close() 关闭该流并释放与之关联的所有资源。
        构造方法:
        BufferedReader(Reader in)创建一个使腥认大小输 入缓中区的缓冲字符输入流。
        BufferedReader(Reader in, int sz)创建一 一个使用指定大小输入缓冲区的缓冲字符输入流。
        参数:
        Reader. in:字符输入流
        我们可以传递FileReader,缓冲流会给FileReader增加一个缓冲区，提高FileReader的读取效率
        特有的成员方法:
        String readline() 读取-一个文本行。读取一行数据
        行的终止符号:通过下列字符之一可认为某行已终止:换行('In')、 回车('Ir') 或回车后直接跟着换行(\r\n)。
        返回值:
        包含该行内容的字符串,不包含任何行终止符，如果已到达流末尾,则返回null
        使用步骤:
        1.创建字符缓冲输入流对象，构造方法中传递字符输入流
        2.使用字符缓冲输入流对象中的方法read/readL ine读取文本
        3.释放资源
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo02BufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\WMQ\\Desktop\\develop\\a.txt"));
       /* String l = br.readLine();
        System.out.println("l = " + l);*/
       String line;
       while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
