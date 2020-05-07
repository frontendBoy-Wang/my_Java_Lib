package code_1_常用函数接口.日志案例;
/*
优化日志:
    Lambda表达式的特点:延迟加载
    Lambda的使用前提:必须存在函数式接口
 */
public class Demo02lambda {
    //定义一个显示日志的方法.方法的参数穿的日志的等级和MessageBuilder接口
    public static void showLog(int level,Demo03MessageBuilder mb){
        //对日志的等级进行判断,如果是1级,则调用MessageBuilder接口中的builderMessage方法
        if (level==1){
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        String msg1="Hello";
        String msg2="World";
        String msg3="Java";

        /*showLog(2,()->{
            //返回一个拼接好的字符串
            return  msg1+msg2+msg3;
        });*/
        /*
        使用L mbd表达式作为参数传递,仅仅是把参数传递到showlog方法中
        只有满足条件,日志的等级是1级
        才会调用接口MessageBuilder中的方法builderMessage
        才会进行字符串的拼接
        如果条件不满足，日志的等级不是级
        那么MessageBuilder接口中的方法builderMessage也不会执行
        所以拼接字符串的代码也不会执行
        所以不会存在性能的浪费
         */
        showLog(1,()->{
            System.out.println("不满足条件不执行");
            //返回一个拼接好的字符串
            return  msg1+msg2+msg3;
        });
    }
}
