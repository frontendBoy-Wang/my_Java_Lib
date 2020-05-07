package c3_IO字节流.FileOutPutStream;

/*
追加写/续写:使用两个参数的构造方法
        FileOutputStream(String name, boolean append)创建一个向具有指定 name的文件中写入数据的输出文件流。
        FileOutPutstream(File file, boolean append) 创建-一个向指定 File对象表示的文件中写入数据的文件输出流。
        参数:
        String name, File file:写入数据的目的地
        boolean append:追加写开关
        true:创建对象不会覆盖源文件，继卖在文件的末尾追加写数据
        false;创建一一个新文件覆盖源文件

   写换行:换行符号
   windows:\r\n
   linux:\n
   mac:\r
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02append字节输出流的追加和换行 {
    public static void main(String[] args) throws IOException {
        //1.创建一个FileOutPutStream对象,构造方法中传递写入数据的路径
        FileOutputStream fos = new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\b.txt",true);
        //2.调用FileOutPutStream对象中的方法write()把数据写入到文件中
        for (int i = 0; i <= 10; i++) {
            fos.write("HelloWorld".getBytes());
            fos.write("\r\n".getBytes());
        }


        //3.释放资源(流的使用会占用一定的内存,使用完需要释放内存,提高程序的效率)
        fos.close();
    }
}
