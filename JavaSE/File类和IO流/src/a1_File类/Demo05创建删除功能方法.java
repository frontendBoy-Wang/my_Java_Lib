package a1_File类;
/*
File类创建删除功能的方法
       public boolean creteMewFile() :当且仅当具有该名称的文件尚不存在时， 创建一个新的空文件。
       public boolean delete() :删除由此File表示的文件或目录。
       public boolean mkdir() :创建由此File表示的目录。
       public boolean mkdirs() :创建由此File表示的目录，包括任何必需但不存在的父目录。
*/

import java.io.File;
import java.io.IOException;


public class Demo05创建删除功能方法 {
    public static void main(String[] args) throws IOException {
        show1();
        show2();
        del1();
    }

    private static void del1() {
        /*public boolean delete() :删余由此File表示的文件或目录。
        此方法,可以删余构造方法路径中给出的文件/文件夹
        返回值:布尔值
        true:文件/文件夹删除成功,返回true
        false:文件夹中有内容,不会删除余返回false;构造方法中路径不存在false
        注意:
        delete方法是直接在硬盘删除文件/文件夹,不走回收站,删除要谨慎*/
        File f1 = new File("D:\\2.txt");
        boolean delete = f1.delete();
        System.out.println("delete = " + delete);

    }

    private static void show2() {
       /* public boolean mkdir() :创建单级空文件夹
        public boolean mkdirs() :既可以创建单级空文件夹，也可以创建多级文件夹
        创建文件夹的路径和名称在构造方法中给出(构造方法的参数)
        返回值:布尔值
        true:文件夹不存在,创建文件夹,返回true
        false:文件夹存在,不会创建,返回false;构造方法中给出的路径不存在返回false
                注意;
        1.此方法只能创建文件夹,不能创建文件
*/
        System.out.println("======================");
        File f1 = new File("aaa");
        boolean mkdir = f1.mkdir();
        System.out.println("mkdir = " + mkdir);

        File f2 = new File("aaa\\111\\222");
        boolean mkdir2 = f2.mkdirs();
        System.out.println("mkdirs2 = " + mkdir2);
    }

    ;

    private static void show1() throws IOException {
        /*
        public boolean createNewFile() :当且仅当具有该名称的文件尚不存在时，创建-一个新的空文件。
        创建文件的路径和名称在构造方法中给出(构造方法的参数)
        返回值:布尔值
        true:文件不存在,创建文件返回true
        false:文件存在,不会创建，返回false
        注意:
        1.此方法只能创建文件,不能创建文件夹
        2.创建文件的路径必须存在,否则会抛出异常
        */
        System.out.println("======================");
        File f1 = new File("C:\\Users\\WMQ\\Desktop\\develop\\1.txt");
        boolean b1 = false;
        b1 = f1.createNewFile();
        System.out.println("b1 = " + b1);

        File f2 = new File("\\2.txt");
        System.out.println(f2.createNewFile());

        File f3 = new File("\\新建文件夹");
        System.out.println(f3.createNewFile());
    }
}
