package com.Collection集合.set集合;

/*
    哈希值:是一个十进制的整数，由系统随机给出(就是对象的地址值,是一个逻辑地址,是模拟出来得到地址,不是数据实际存储的物理地址)
    在object类有一个方法， 可以获取对象的哈希值
    int hashcode()返回该对象的哈希码值。
    hashCode方法的源码:
    public native int hashCode();
    native:代表该方法调用的是本地操作系统的方法

 */
public class Demo02HashCode {
    public static void main(String[] args) {
        //Person类继承了Object类,所以可以使用Object类的hashCode方法
        Person p1=new Person();
        int h1=p1.hashCode();
        System.out.println(h1);

        Person p2 = new Person();
        int h2=p2.hashCode();
        System.out.println(h2);

        /*
        * toString方法的源码:
                  return getCLass().getNome() +“@" + Integer. toHexString(hashCode());
*/
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1==p2);//false

        /*String类的哈希值
            String类重写Object类的hashCode
        */
        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println("s2 = " + s2.hashCode());
        System.out.println("s1 = " + s1.hashCode());
        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
    }
}
class Person{

}
