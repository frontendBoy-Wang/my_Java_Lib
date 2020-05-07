package com.泛型;
/*
定义含有泛型的方法:泛型定义在方法的修饰符和近回值类型之间
    格式:
    修饰符 <泛型>返回值类型方法名(参数列康(使用泛型){
        方法体;
    }
    含有泛型的方法，在调用方法的对候确定泛型的数据类型
    传递什么类型的参数，泛型就是什么类型

 */
public class GenericMethod {
    //定义一个含有泛型的方法
    public<M> void  method(M m){
        System.out.println(m);
    }
    //定义一个含有泛型的静态方法
    public static <S> void  method01(S s){
        System.out.println(s);
    }
}

class text{
    public static void main(String[] args) {
        GenericMethod gm=new GenericMethod();

        /*
        调用含有泛型的方法method01
        传递什么类型，泛型就是什么类型
        */
        gm.method(10);
        gm.method("ab");
        gm.method(0.3);
        gm.method(true);

        gm.method("静态方法不介意创建对象使用");
        //静态方法,通过类名使用.方法名(参数),可以直接使用
        GenericMethod.method01("静态方法");
        GenericMethod.method01(1);
    }
}
