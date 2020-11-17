package a1_File类;

/*
路径:
        绝对路径:是一-个完整的路径
        以盘符(c:,D: )开始的路径
        c:lla.txt
        C:l\Users\itcastl\IdeaProjects\ \shungyuan\123. txt
        D:l\demo\lb. txt
        相对路径:是-一个简化的路径
        相对指的是相对于当前项目的根目录(C:\lusers\itcostl\IdeaProjectsllshungyuan)
        如果使用当前项目的根目录，路径可以简化书写
        C:l\Users\itcastl\IdeaProjects\' ishungyuan)\123. txt-->简化为: 123. txt(可以省略项目的根目录)
        注意:
        1.路径是不区分大小写
        2.路径中的文件名称分隔符windows使用反斜杠,反斜杠是转义字符两个反斜杠代表-一个普通的反斜杠
*/

import java.io.File;

public class Demo02File绝对路径和相对路径 {
    //File类的构造方法
    public static void main(String[] args) {
        show1();
        show2("c:\\","a.txt");
        show03();
    }

    private static void show03() {
        /*
        File(File parent, string child) 根据parent抽象路径名和child 路径名字符串创建一一个新File实例。
        参数:把路径分成了两部分
            File parent:父路径
            string child:子路径
        好处:
            父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路经都可以变化
            父路径是File类型，可以使用File的方法对路径进行一些操作，再使用路径创建对象
         */
        File parent=new File("c:\\");
        File file1 =new File(parent,"hello,java");
        System.out.println("file = " + file1);//file1 = c:\hello,java

    }

    private static void show2(String parent, String child) {
        /*
        File(String parent, String child) 根据parent 路径名字符串和child 路径名字符串创建-一个新 File 实例。
        参数:把路径分成了两部分
        String parent:父路径
        String child:子路径
        好处:
        父路径和子路径，可以单独书写，使用起来非常灵活:父路径和子路径都可以变化
        */
        File file=new File(parent,child);
        System.out.println("file = " + file);
    }

    /*
    File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建-一个新File 实例。
    参数:
    string pathname :字符串的路径名称
            路径可以是以文件结尾,也可以是以文件夹结尾
    路径可以是相对路径，也可以是绝对路径
    路径可以是存在，也可以是不存在
            创建File对象,只是把字符串路径封装为File对象,不考虑路径的真假情况
*/
    private static void show1() {
        File f1 = new File("D:\\学习\\Java\\a.txt");
        System.out.println("f1 = " + f1);//重写了toString方法

        File f2 = new File("D:\\学习\\Java");
        System.out.println("f1 = " + f2);

        File f3 = new File("b.txt");
        System.out.println("f3 = " + f3);
    }


}
