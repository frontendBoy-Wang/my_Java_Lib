package a1_File类;

/*
public String getAbsolutePath();返回此File的绝对路径名字符串。

public String getPath()：将此File转换为路径名字符串。

public String getName()：返回由此File表示的文件或目录的名称。

public long length()：返回由此File表示的文件的长度。
*/

import java.io.File;

public class Demo03File类的常用方法 {
    public static void main(String[] args) {
        show1();
        show2();
        show3();
        show4();
    }

    private static void show4() {
        //public long length()：返回由此File表示的文件的长度。
        //获取的是构造方法指定的文件的大小,以字节为单位
        //注意:
        //  文件夹是没有大小写的概念.不能获取文件夹的大小
        //如果构造方法中给出的路径不存在,那么length方法返回0
        System.out.println("show4----------------->");
        File f1=new File("C:\\Users\\WMQ\\Desktop\\develop\\1.png");
        long length1 = f1.length();
        System.out.println("length1 = " + length1);//72670字节

        File f2=new File("C:\\Users\\WMQ\\Desktop\\develop\\2.png");
        System.out.println(f2.length());//路径文件不存在返回0

        File f3=new File("C:\\Users\\WMQ\\Desktop\\develop");
        long length3 = f3.length();
        System.out.println("length3 = " + length3);//0文件夹没有大小概念

    }

    private static void show3() {
        //public String getName()：返回由此File表示的文件或目录的名称。
        System.out.println("show3----------------->");
        File f1=new File("D:\\学习\\Java\\a.txt");
        String name1 = f1.getName();
        System.out.println("name1 = " + name1);//a.txt

        File f2=new File("D:\\学习\\Java");
        String name2 = f2.getName();
        System.out.println("name2 = " + name2);//a.txt
    }

    private static void show2() {
        //public String getPath()：将此File转换为路径名字符串。
        //获取构造方法中传递的路径
        System.out.println("show2----------------->");
        File f1=new File("D:\\学习\\Java\\a.txt");
        File f2=new File("a.txt");
        String path1 = f1.getPath();
        System.out.println("path1 = " + path1);
        String path2 = f2.getPath();
        System.out.println("path2 = " + path2);

        System.out.println(f1);
        System.out.println(f1.toString());
    }

    private static void show1() {
       /*
        public String getAbsolutePath() :返回此File的绝对路径名字符串。
        获取的构造方法中传递的路径
        无论路径是绝对的还是相对的，getAbsolutePath方法返回的都是绝对路径
        */
        System.out.println("show1----------------->");
        File f1 = new File("D:\\学习\\Java\\a.txt");
        String absolutePath1 = f1.getAbsolutePath();
        System.out.println("absolutePath1 = " + absolutePath1);

        File f2 = new File("a.txt");
        String absolutePath2 = f2.getAbsolutePath();
        System.out.println("absolutePath2 = " + absolutePath2);
    }
}
