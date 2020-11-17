package wmq.Throw;


import java.util.Objects;

/*
    Objects类中的静态方法
    public static <T> T requireNonNull(T obj):查看指定引用对象不是nullo .
    源码:
    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }
 */
public class Demo04Objects {
    public static void main(String[] args) {
        method1(null);

    }

    private static void method1(Objects obj) {
        //对传递过来的参数合法性判断,判断是否为null
        /*if (obj==null){
            throw new NullPointerException("传递的对象的值是null");
        }*/
        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj,"传递的对象的值是null");
    }
}
