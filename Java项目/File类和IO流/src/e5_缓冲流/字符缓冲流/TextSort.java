package e5_缓冲流.字符缓冲流;

/*
练习:
        对文本的内容进行排序
        按照(123....)顺序排序
        分析:
        1.创建一-个HoshMap集合对象, 可以:存储每行文本的序号(,23..);value:存储每行的文本
        2.创建字符缓冲输入流对象，构造方法中绑定字符输入流
        3.创建字符缓冲输出流对象,构造方法中绑定字符输出流
        4.使用字符缓冲输入流中的方法readline,逐行读取文本
        5.对读取到的文本进行切割，获取行中的序号和文本内容
        6.把切害好子的序号和文本的内容存储到HashMp集合中(key序号是有序的,会自动排序1,2,3,4..)
        7.遍历HoshMap集合,获取每一-个键值对
        8.把每一个键值对,拼接为-一个文本行
        9.把拼接好的文本，使用字符缓冲输出流中的方法write,写入到文件中
        10.释放资源
*/

import java.io.*;
import java.util.HashMap;

public class TextSort {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\WMQ\\Desktop\\develop\\1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\WMQ\\Desktop\\develop\\2.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("\\.");
            map.put(arr[0], arr[1]);

        }
        for (String key : map.keySet()) {
            String value = map.get(key);
            line = key + "." + value;
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

}
