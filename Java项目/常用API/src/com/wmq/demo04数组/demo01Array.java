package com.wmq.demo04数组;


/*
定义一个数组,用来储存3个Person对象

数组有一个缺点：一旦创建，程序运行期间长度不能发生改变
*/
public class demo01Array {
    public static void main(String[] args) {
        //首先创建一个长度为3的数组，用来存放Person类型的对象
        Person[] array = new Person[3];

        Person one = new Person("迪丽热巴", 18);
        Person two = new Person("古力娜扎", 28);
        Person three = new Person("玛尔扎哈", 38);

        //将one中的值赋值到数组0号元素的位置
        array[0] = one;
        array[1] = two;
        array[2] = three;

        System.out.println(array[0]);//地址值
        System.out.println(array[1]);//地址值
        System.out.println(array[2]);//地址值

        System.out.println(array[1].getName());//古力娜扎

    }
}
