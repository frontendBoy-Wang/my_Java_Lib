package a_2递归;

import java.io.File;

public class Demo05目录搜索 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\WMQ\\Desktop\\develop");
        getFiles(file);
    }

    private static void getFiles(File dir) {
        //System.out.println(dir);//打印目录
        File[] files = dir.listFiles();
        for (File f : files) {
            //对遍历得到的File对象f进行判断,判断是否是文件夹
            if (f.isDirectory()) {
                //f是-一个文件夹,则继续遍历这个文件夹
                //我们发现etAllFile方法就是传递文件夹，遍历文件夹的方法
                //所以直接调用getAllFile方法即呵:递归(自己调用自己)
                getFiles(f);
            } else {
                //是一个文件, 直接打印
                /*
                只要是,Java结尾的文件
                1.就把File对象f,转换为字符串对象
                 */
                //String name = f.getName();
                //String path = f.getPath();
                String s = f.toString();

                //把字符串转换成小写
                s=s.toLowerCase();

                //调用String类中的方法endWith判断是否以.java结尾
                boolean b = s.endsWith(".txt");

                //如果是以Java 就输出
                /*if(b){
                    System.out.println(f);
                }*/

                if(f.getName().endsWith(".txt")){
                    System.out.println(f);
                }

            }
        }

    }
}
