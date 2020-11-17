package com.wmq.demo02匿名对象;

/*
匿名对象就是只有右边的对象，没有左边的名字和赋值运算符
new 类名称（）；

注意事项：匿名对象只能使用唯一的一次，下次再用不得不在创建一个新的对象
使用建议：如果确定有一个对象只需要使用唯一的一次就可以用匿名对象
*/
public class demo01Anonymous {
    public static void main(String[] args) {
        Person one=new Person();
        one.name="汪满青";
        one.showName();

        //匿名对象
        new Person().name="赵琴";
        new Person().showName();//null
    }
}
