package code_1_常用函数接口.日志案例;
/*
日志案例
发现以下代码存在的一些性能浪费的问题
调月showL og方法，传递的第二个参数是一一个拼接后的字符串
先把字符串拼接好,然后在调用showLog方法
showLog方法中如果传递的日志等级不是1级
那么就不会是如此拼接后的字符串
所以感觉字符串就白拼接了,存在了浪费

 */
public class Lambda  {
    //定义一个根据日志级别.显示日志信息的方法
    public static void main(String[] args) {
        String msg1="Hello";
        String msg2="World";
        String msg3="Java";

    showLog(1,msg1+msg2+msg3);
    }

    private static void showLog(int level,String message) {
        //日志的等级进行判断.如果是1级别就输出日志
        if(level==1){
            System.out.println(message);
        }
    }


}
