package com.泛型;
/*
    定义一个含有泛型的类,模拟ArrayList集合
    定义一个含有泛型的类,模批ArrayList集合
    泛型是一个未知的数据类型，当我们不确定什么什么数据类型的时候，可以使用泛型
    泛型可以接收任意的数据类型，可使用Integer,String,student...
    创建对象的时候确定泛型的数据类型

 */
public class GenericClass<E> {
   private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
class test{
    public static void main(String[] args) {
//        不写泛型,默认是object类型
        GenericClass gc=new GenericClass();
        gc.setName("只能是字符串");
        Object obj=gc.getName();

//        创建一个object对象,泛型使用Integer类型
        GenericClass<Integer> gc2=new GenericClass<>();
        gc2.setName(1);
        Integer name2 = gc2.getName();
        System.out.println(name2);

//        创建一个object对象,泛型使用Integer类型
        GenericClass<String> gc3=new GenericClass<>();
        gc3.setName("小明");
        String name3 = gc3.getName();
        System.out.println(name3);
    }
}
