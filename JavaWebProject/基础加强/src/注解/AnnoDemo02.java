package 注解;

import java.util.Date;

/**
 * jdk中的注解
 * * @override : 检测被该注解标注的方法是否是继承自父类(接口)的
 * * @Deprecated :该注解标注的内容,表示已过时
 * * @suppressWarnings :压制警告
 */
@SuppressWarnings("all")
public class AnnoDemo02 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {
    }

    //@MyAnno
    public void show2() {

    }

    public void demo() {
        show1();
        Date date = new Date();
    }
}
