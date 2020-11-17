package a1_File类;

/*
File判断功能的方法
public boolean exists() :此File表示的文件或目录是否实际存在。
public boolean isDirectory() : 此File表示的是否为目录。
public boolean isFile() :此File:表示的是否为文件。
*/

import java.io.File;

public class Demo04判断方法 {
    public static void main(String[] args) {
        show01();
        show02();
    }

    private static void show02() {
       /*
        public boolean isDirectory() : 此File表示的是否为目录。
       用于判断构造方法走给定的路径是否以文件夹结尾
        是true
        否false
       public boolean isFile() :此File:表示的是否为文件。
       用于判断构造方法中给定的路径是否以文件结尾
        是:true
        否:false .
       注意:
       电脑的硬盘中只有文件/文件夹,两个方法是互斥
       这两个方法使用前提，路径必须是存在的，否则都返回false
        */
        System.out.println("show2======================");
        File f1 = new File("C:\\Users\\WMQ\\Desktop\\develo");

        //不存在就没有邀请获取
        if (f1.exists()) {
            System.out.println("f1 = " + f1.isDirectory());//false
            System.out.println("f1 = " + f1.isFile());//false
        }

        File f2 = new File("C:\\Users\\WMQ\\Desktop\\develop");
        if (f2.exists()) {
            System.out.println("f2 = " + f2.isDirectory());//true
            System.out.println("f2 = " + f2.isFile());//false

        }
        File f3 = new File("C:\\Users\\WMQ\\Desktop\\develop\\a.txt");
        if (f3.exists()) {
            System.out.println("f3 = " + f3.isDirectory());//false
            System.out.println("f3 = " + f3.isFile());//true

        }
    }

    private static void show01() {
        System.out.println("show1==================");
        //public boolean exists() :此File表示的文件或目录是否实际存在。
        File f1 = new File("C:\\Users\\WMQ\\Desktop\\develop");
        System.out.println("f1 = " + f1.exists());//true

        File f2 = new File("C:\\Users\\WMQ\\Desktop\\develo");
        System.out.println("f2 = " + f2.exists());//false


    }
}
