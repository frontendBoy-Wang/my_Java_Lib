package code3综合案例_文件上传.优化;

/*
TCP通信的文件上传案例
原理:客户端读取本地的文件,把文件上传到服务器服务器在把上传的文件保存到服务器的硬盘上
    1.客户端使用本地的字节输入流读取要上传的文件
    2.客户端使用网络字节输出流,把读取到的文件上传到服务器
    3.服务器使用网络字节输入流读取客户端上传的文件
    4.服务器使用本地字节输出流,把读取到的文件保存到服务器的硬盘上
    5.服务器使用网络字节输出流给客户端回写-个"上传成功"
    6.客户端使用网络字节输入流读取服务器回写的数据
    7.释放资源;
注意:
    客户端和服务器和本地硬盘进行读写,需要使用自己创建的字节流对象(本地流)
    客户端和服务器之间进行读写，必须使用Socke中提供的字节流对象网络流)
    文件上传的原理，就是文件的复制
明确:
    数据源
    数据目的地
*/
/*
文件上传案例的客户端:读取本地文件,上传到服务器,读取服务器回写的数据
明确:
    数据源:c:\\1,jpg
    目的地:服务器
实现步骤:
    1.创建一一个本地字节输入流FileInputStream对象,构造方法中绑定要读取的数据源
    2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
    3.使用Socket中的方法get0utputStream,获取网络字节输出流0utputStream对象
    4.使用本地字节输入流FileInputStream对象中的方法read,读取本地文件
    5.使用网络字节输出流OutputStreom对象中的方法write,把读取到的文件上传到服务器
    6.使用Socket中的方法getInputStream,获取网各字节输入流InputStream对象
    7.使用网络字节输入流InputStream对象中的方法read读取服务回写的数据
    8.释放资源(FileInputStream, Socket)
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一一个本地字节输入流FileInputStream对象,构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\pic.jpg");
        //2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号


        Socket socket = new Socket("192.168.1.5", 8888);
        //3.使用Socket中的方法get0utputStream,获取网络字节输出流0utputStream对象
        OutputStream os = socket.getOutputStream();
        //4.使用本地字节输入流FileInputStream对象中的方法read,读取本地文件
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            //5.使用网络字节输出流OutputStreom对象中的方法write,把读取到的文件上传到服务器
            os.write(bytes, 0, len);
        }

        /*
        *   解决:上传完文件给服务器写一个结束标记
            void shutdown0Output() 禁用此套接字的输出流。
            对于TCP套接字,任何以前写入的数据都将被发送，并且后跟TCP的正常连接终止序列。
        */
        socket.shutdownOutput();
        //6.使用Socket中的方法getInputStream,获取网各字节输入流InputStream对象
        InputStream is = socket.getInputStream();

        //7.使用网络字节输入流InputStream对象中的方法read读取服务回写的数据
        while ((len = is.read(bytes)) != -1) {

            System.out.println(new String(bytes, 0, len));
        }
        //8.释放资源(FileInputStream, Socket)
        fis.close();
        socket.close();
    }
}
