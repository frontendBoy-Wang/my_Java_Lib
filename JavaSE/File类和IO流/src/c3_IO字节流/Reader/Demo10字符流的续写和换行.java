package c3_IO字节流.Reader;


/*
续写和换行
        续写，追加写:使用两个参数的构造方法
        FileWriter(string fileName, boolean append)
        FileWriter(File. file, boolean append)
        参数:
        String fileNome, File file:写入数据的目的地
        boolean append:续写开关true :不会创建新的文件覆盖源文件,可以续写; false:创建新的文件覆盖源文件
        换行:换行符号
        windows:\r\n
        linux:/n
        mac:/r
*/

import java.io.FileWriter;
import java.io.IOException;

public class Demo10字符流的续写和换行 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\WMQ\\Desktop\\develop\\b.txt", true);
        for (int i = 0; i < 10; i++) {
            fw.write("Heool\r\n " + i);
        }
        fw.close();
    }
}
