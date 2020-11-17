package wmq.tryCatchFinally;
/*
try...catch:异常处理的第.种方式,自己处理异常
        格式:
        try{
        可能产生异常的代码
        }catch(定义- -个异常的变量，用来接收try中抛出的异常对象){
        异常的处理逻辑，异常异常对象之后，怎么处理异常对象
        -般在工作中，会把异常的信息记录到一-个日志中
        }
        catch(异常类名变量名){
        注意:
        1. try中可能会抛出多个异常对象，那么就可以使用多个catch来处理这些异常对象
        2.如果try中产生了异常，那么就会执行catch中的异常处理逻辑执行完毕catch中的处理逻辑,继续执行ry... cotch之后的代码
          如果try中没有产生异常,那么就不会执行catch中异常的处理逻辑,执行完try中的代码,继续执行tr...cotch之后的代码
*/

import java.io.IOException;

public class Demo01TryCatch {
    public static void main(String[] args) {
        try {
            //可能产生异常的代码
            readFile("d:\\a.tx");
            System.out.println("资源释放");
        } catch (IOException e) {//try中抛出什么异常对象,catch就定义什么异常处理变量,用来接受异常对象
            //异常的处理逻辑，异常异常对象之后，怎么处理异常对象
            //System.out.println("catch-传递的文件路径不是c:\\a.txt");

            /*
            Throwable类中定义了3个异常处理方法
            String getMessage() 返回此throwable 的简短描述。
            String toString() 返回此throwable 的详细消息字符串。
            void printStackTrace() JVM打印异常对象, 默认此方法，打印的异常信息是最全面的
            */
            //System.out.println(e.getMessage());
            //System.out.println(e.toString());///重写Object类的toString java. io. IOException: 文件的后缀名不对
            //System.out.println(e);//java.io.IOException: 路径不对

            /*
                java.io.IOException: 路径不对
                at wmq.tryCatchFinally.Demo01TryCatch.readFile(Demo01TryCatch.java:50)
                at wmq.tryCatchFinally.Demo01TryCatch.main(Demo01TryCatch.java:25)
            */
            e.printStackTrace();
        }
        System.out.println("后续");
    }

    /*
        如果传递的路径,不是. txt结尾
        那么我们就抛出功0异常对象,告知方法的调用者,文件的后缀名不对
    */
    public static void readFile(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            throw new IOException("路径不对");
        }
        System.out.println("路径没有问题");

    }

}
