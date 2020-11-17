package b2_过滤器;

import java.io.File;
import java.io.FileFilter;

/*
练习:

        递归3打印多级目录
        需求:
        遍历c:\\abc文件夹,及abc文件夹的子文件夹
        c:\\abc
        c:\\abc\\abc.txt
        c:\\abc\\abc.java
        C:\\abc\\a
        c:\\abl\a\\a.jpg
        C:\\abc\\a\\a.java
        c:\\abc\\b
        C:\\abc\\b\\b.java
        c:\\abc\\pb.txt

        使用过滤器实现需求
        在File类中有两个ListFiles重载的方法
        我们可以使用过滤器来实现

        在File类中有两个和ListFiles重载的方法，方法的参数传递的就是过滤器
        File[] listFiles(FileFilter filter)
        java.io.FileFilter接口:用于抽象路径名(File对象)的过滤器。
        作用:用来过滤文件(File对象)
        抽象方法:用来过滤文件的方法
        boolean accept(File pathname) 测试指定抽象路径名是否应该包含在某个路径名列表中。
        参数:
        File pathname:使用listFiles方法遍历目录,得到的每一一个文件对象
        File[] listFires(FilenameFilter filter)
        java. io.FilenameFilter接口:实现此接口的类实例可用于过滤器文件名。
        作用:用于过滤文件名称
        抽象方法:用来过滤文件的方法
        boolean accept(File dir, string name) 测试指定文件是否应该包含在某一文件列表中。
        参数:
        File dir:构造方法中传递的被遍历的目录
        string name:使用L istFiles方法遍历且录，获取的每一一个文件/文件夹的名称
        注意:
        两个过滤器接口是没有实现类的,需要我们自己写实现类,重写过滤的方法accept,在方法中自己定义过滤的规则
*/
public class Demo01Filter {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\WMQ\\Desktop\\develop");
        getFiles(file);
    }

    private static void getFiles(File dir) {
        //System.out.println(dir);//打印目录
       /* File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //过滤规则
                return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".txt");
            }
        });//传递过滤器对象*/

      File[] files= dir.listFiles();


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


//创建过滤器的实现类,重写过滤方法accept,定义过滤规则
class FileFilterImpl implements FileFilter{

    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()){
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".txt");
    }
}
