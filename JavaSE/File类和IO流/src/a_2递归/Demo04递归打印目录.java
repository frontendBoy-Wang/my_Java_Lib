package a_2递归;

import java.io.File;

/*
练习:

        递归3打印多级目录
        需求:
        遍历c:\labc文件夹,及abc文件夹的子文件夹
        c:l\abc
        c:l\abc\\abc.txt
        c:\labc\ \abc.java
        C:I\abc\la
        c:l\abl\a\\a.jpg
        C:l\abc\\a\\a.java
        c:l\abc\\b
        C:l\abc\\bl\b.java
        c:\\abcl\pb. txt
*/
public class Demo04递归打印目录 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\WMQ\\Desktop\\develop");
        getFiles(file);
    }

    private static void getFiles(File dir) {
        System.out.println(dir);//打印目录
        File[] files = dir.listFiles();
        for (File f : files) {
            //对遍历得到的File对象f进行判断,判断是否是文件夹
            if (f.isDirectory()) {
            //f是-一个文件夹,则继续遍历这个文件夹
            //我们发现etAllFile方法就是传递文件夹，遍历文件夹的方法
            //所以直接调用getAllFile方法即呵:递归(自己调用自己)
                getFiles(f);
            } else {
            //是一个文件, 直接打印明呵
                System.out.println(f);

            }
        }

    }
}
