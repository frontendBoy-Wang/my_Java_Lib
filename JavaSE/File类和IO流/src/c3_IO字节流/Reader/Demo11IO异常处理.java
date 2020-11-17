package c3_IO字节流.Reader;

import java.io.FileWriter;
import java.io.IOException;
/*

在jlk1.7之前使用try cath finlly处理波中的异常
        格式:
        try{
        可能会产出异常的代码
        }catch(异常类变量变量名){
        异常的处理逻辑I
        }finally{
        一定会指定的代码
        资源释放
*/

public class Demo11IO异常处理 {
    public static void main(String[] args) {
        //提高变量fw的作用域,让finally可以使用
        //变量在定义的时候，可以没有值，但是使用的时候必须有值
        //fw = new FileWriter("09 _IOAndPropertieslg. txt", true);执行失败, fw没有值，fw.close会报错
        FileWriter fw = null;
        try {
            fw = new FileWriter("l:\\Users\\WMQ\\Desktop\\develop\\b.txt", true);
            for (int i = 0; i < 10; i++) {
                fw.write("HelloWorld\r\n " + i);
            }

        } catch (IOException e) {
            System.out.println("e = " + e);
        } finally {
            //一定会执行的代码
            //创建对象失败了, fuw的黑默认值就是null, null是不能调用方法的，
            //会抛出NullPointerException,需要增加一个判断,不是null在把资源释放
            if (fw != null) {
                try {
                    //fw.close方法声明抛出，IOException异常对象,所以我们就的处理这个异常对象，要么throws ,要么try catch
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
