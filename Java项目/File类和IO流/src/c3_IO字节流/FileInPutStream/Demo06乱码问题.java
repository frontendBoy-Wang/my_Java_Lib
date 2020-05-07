package c3_IO字节流.FileInPutStream;

/*
使用字节流读取中文文件
        1个中文
        GBK:占用两个字节
        UTF-8:占用3个字节
*/

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Demo06乱码问题 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
        int len;
        while ((len = fis.read()) != -1) {
            System.out.print((char) len);
        }
        fis.close();
    }
}


    /*
    解决方案:FileReader类----Reader字符输入流
    public static void main(String[] args) throws IOException {
        Reader fr = new Reader("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
        int len;
        while ((len = fr.read()) != -1) {
            System.out.print((char)len);
        }
        fr.close();
    }
*/