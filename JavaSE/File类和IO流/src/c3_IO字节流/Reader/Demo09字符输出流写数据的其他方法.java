package c3_IO字节流.Reader;
/*

字符输出流写数据的其他方法:
  void write(char[] cbuf)写入字符数组。
  abstract void write(char[] cbuf, int off, int len)写入字符数组的某一 部分，of数组的开始索引，len写的字符个数。
  void write(String str)写入字符串。
  void write(String str, int off, int Len) 写入字符串的某一部分， off字符串的开始索引, len写的字符个数。
*/

import java.io.FileWriter;
import java.io.IOException;

public class Demo09字符输出流写数据的其他方法 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\WMQ\\Desktop\\develop\\b.txt");
        char[] cs = {'a', 'b', 'c', 'd','e'};
        //void write(char[] cbuf)写入字符数组。
        fw.write(cs);//abcd
        fw.write(cs,1,3);
        fw.write("汪满青");
        fw.write("黑马程序员",2,3);
        fw.close();
    }

}
