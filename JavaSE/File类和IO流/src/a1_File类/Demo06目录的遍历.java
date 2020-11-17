package a1_File类;

/*
File类遍历(文件夹)目录功能
        - public String[] list() :返回一个String数组,表示该File目录中的所有子文件或目录。
        . public File[] listFiles() :返回一个File数组，表示该File目录中的所有的子文件或目录。
        注意:
        list方法和listFiles方法遍历的是构造方法中给出的目录
        如果构造方法中给出的目录的路径不存在，会抛出空指针异常
        如果构造方法中给出的路径不是一一个目录， 也会抛出空指针异常
*/

import java.io.File;

public class Demo06目录的遍历 {
   /* public String[] list() :返回一个String数组,表示该File目录中的所有子文件或目录。
    遍历构造方法中给出的目录，会获取目录中所有文件/文件夹的名称,把获取到的多个名称存储到一-个*/
   public static void main(String[] args) {
       show1();
   }

    private static void show1() {
        File f1 = new File("C:\\Users\\WMQ\\Desktop\\develop");
        String[] l1 = f1.list();
        for (String s : l1) {
            System.out.println("s = " + s);
        }

        File f2 = new File("C:\\Users\\WMQ\\Desktop");
        File[] l2 = f2.listFiles();
        for (File file : l2) {
            System.out.println("file = " + file);
        }

    }

}
