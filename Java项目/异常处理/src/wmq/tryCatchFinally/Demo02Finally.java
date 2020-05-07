package wmq.tryCatchFinally;
/*
finally代码块
        格式:
            try{
                可能产生异常的代码
        }catch(定义一-个异常的变量，用来接收try中抛出的异常对象){
            异常的处理逻辑，异常异常对象之后，怎么处理异常对象
            一般在工作中，会把异常的信息记录到一个日志中
        catch(异常类名变量名){
        }finally{
            无论是否出现异常都会执行
        注意:
            1.finally不能单独使用，必须和try- -起使用
            2.finally-般用于资源释放(资源回收),无论程序是否出现异常,最后都要资源释放(IO)
*/

import java.io.IOException;

public class Demo02Finally {
    public static void main(String[] args) {
        try {
            //可能会产生异常的代码
            readFile("c:\\a.txt");
        } catch (IOException e) {
            //异常的处理逻辑
            e.printStackTrace();
        }finally {
            //无论是否出现异常,都会执行
            System.out.println("资源释放");
        }
    }
    /*
       如果传递的路径,不是. txt结尾
       那么我们就抛出功0异常对象,告知方法的调用者,文件的后缀名不对
   */
    public static void readFile(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            throw new IOException("路径不对");
        }
        System.out.println("路径没有问题,读取文件");

    }
}
