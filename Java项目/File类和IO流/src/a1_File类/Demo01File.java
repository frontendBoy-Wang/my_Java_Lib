package a1_File类;
/*
java. io.File类
        文件和目录路径名的抽象表示形式。
        java把电脑中的文件和文件夹(目录)封装为了一个File类,我们可以使用File类对文件和文件夹进行操作
        我们可以使用File类的方法
        创建一个文件/文件夹
        删除文件/文件夹.
        获取文件/文件夹
        判断文件/文件夹是否存在
        对文件夹进行遍历
        获取文件的大小
        File类是一个与系统无关的类，任何的操作系统都可以使用这个类中的方法
        重点:记住这三个单词
            file:文件
            directory:文件夹/目录
            path:路径
*/

import java.io.File;

public class Demo01File {
    /*static String pathSeparator与系统相关的路径分隔符字符，为方便起见，表示为字符串。
    static char pathSeparatorChar与系统相关的路径分隔符。
    static String separator与系统相关的默认名称 - 分隔符字符，以方便的方式表示为字符串。
    static char separatorChar与系统相关的默认名称分隔符
    。*/

    /*操作路径:路径不能写死了
    C: \develop\a\a.txt windows
    C:/develop/a/a.txt linux
    "C:"+File. separator+ "develop"+File. separator+"+File. separator+"a, txt"
*/
    public static void main(String[] args) {
        String pathSeparator = File.pathSeparator;
        System.out.println("pathSeparator = " + pathSeparator);////路径分隔符windows;分号; linux:冒号:

        String separator = File.separator;
        System.out.println("separator = " + separator);//文件名称分隔符windows:反斜杠\,Linux系统:正斜杠/
    }

}
