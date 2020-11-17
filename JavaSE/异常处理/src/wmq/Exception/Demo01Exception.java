package wmq.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    java.lang. Throwable:类是Java 语言中所有错误或异常的超类。
        Exception:编译期异常,进行编译(写代码)java程序出现的问题
            RuntimeException :运行期异常，jdp程序运行过程中出现的问题
            异常就相当于程序得了一个小毛病(感冒，发烧),把异常处理掉，程序可以继续执行(吃点药,继续革命工作)
        Error:错误
            错误就相当于程序得了一个无法治愈的毛病(非典,艾滋)。必须修改源代码,程序才能继续执行

 */

public class Demo01Exception {
    public static void main(String[] args) /*throws ParseException*/ {
        //Exception:编译期异常,进行编译(写代码)java程序出现的问题
       /* SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//日期格式化类
        try {
            Date date = sdf.parse("1999-04-11");//把字符串格式的日期解析为Date格式的日期
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //RuntimeException :运行期异常，jdp程序运行过程中出现的问题
        /*int[] arr = {1, 2, 3};
        try {
            //可能会出现异常的代码
            System.out.println(arr[3]);//ArrayIndexOutOfBoundsException数组索引越界异常
        } catch (Exception e) {
            //异常的处理逻辑
            System.out.println(e);
            System.out.println("数组索引越界异常");
        }
        System.out.println("后续代码");*/

        /*
        * Error错误
        * OutOfMemoryError: Java heap space
        * 内存溢出的错误,创建的数组太大了,超出了jvm分配的内存
        * 必须修改源代码
        * */
        /*int[] arr=new int[1024*1024*1024];
        System.out.println("后续代码");*/
    }
}
