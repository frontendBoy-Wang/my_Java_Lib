package d_4_Properties属性集;

/*
java.util. Properties集合extends Hashtable<k, v> implements Map<k, v>
Properties类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。
        Properties集合是-一个唯- 和IO流相结合的集合
        可以使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
        可以使用Properties集合中的方法Load,把硬盘中保存的文件(键值对),读取到集合中使用
        属性列表中每个键及其对应值都是一一个字符串。
        Properties集合是-一个双列集合, key和value黑默认都是字符串
*/

import java.io.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

public class Demo01Properties {
    public static void main(String[] args) throws IOException {
        //show();
        //show1();
        show2();
    }

    private static void show2() throws IOException {
        /*
        可以使用Properties集合中的方法load,把硬盘中保存的文件(键值对),读取到集合中使用
        void load(InputStream inStream)
        void load(Reader reader)
        参数:
        InputStream inStream:字节输入流, 不能读取含有中文的键值对
        Reader reader:字符输入流,能读取含有中文的键值对
        使用步骤:
        I 1.创建Properties集合对象
        2.使用Properties集合对象中的方法Load读取保存键值对的文件
        3.遍历Properties集合
        注意:
        1.存储键值对的文件中,键与值默认的连接符号可以使用=,空格(其他符号)
        2.存储键值对的文件中,可以使用进行注释，被注释的键值对不会再被读取
        3.存储键值对的文件中，键与值黑大认都是字符串,不用再加引号
        */

        Properties prop = new Properties();
        prop.load(new FileReader("C:\\Users\\WMQ\\Desktop\\develop\\1.txt"));
        Set<String> set=prop.stringPropertyNames();
        for (String k : set) {
            String value=prop.getProperty(k);
            System.out.println(k+value);
        }

    }

    private static void show1() throws IOException {
        /*
        可以使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储
        void store(outputStream out, String comments)
        void store(Writer writer, String comments)
        参数:
        OutputStream out :字节输出流,不能写入中文
        Writer writer:字符输出流,可以写中文
        string comments:注释, 用来解释说明保存的文件是做什么用的
        不能使用中文,会产生乱码，默认是Unicode编码
                -般使用”空字符串
        使用步骤:
        1.创建Properties集合对象,添加数据
        2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        3.使用Properties集合中的方法store,
        4.释放资源
        */

        Properties prpo = new Properties();
        prpo.setProperty("迪丽热巴", "170");
        prpo.setProperty("古力娜扎", "165");
        prpo.setProperty("热依扎", "172");

        //2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        //FileWriter fw=new FileWriter("C:\\Users\\WMQ\\Desktop\\develop\\1.txt");
        //prpo.store(fw,"save data");
        //fw.close();

        //prpo.store(new FileOutputStream("C:\\Users\\WMQ\\Desktop\\develop\\1.txt"),"");
    }


    private static void show() {
        /*
        使用Properties集合存储数据,遍历取出Properties集合中的数据
        Properties集合是-一个双列集合，key和value黑尤认都是字符串
        */
        Properties prpo = new Properties();
        prpo.setProperty("迪丽热巴", "170");
        prpo.setProperty("古力娜扎", "165");
        prpo.setProperty("热依扎", "172");

        Set<String> set = prpo.stringPropertyNames();

        for (String Key : set) {
            String values = prpo.getProperty(Key);
            System.out.println(Key + "= " + values);
        }

    }
}
