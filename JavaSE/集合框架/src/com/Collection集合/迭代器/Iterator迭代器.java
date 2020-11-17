package com.Collection集合.迭代器;
/*
在程序开发中,经常需要遍历集合中的所有元素。
针这种需求，JDK专门提供了一个接口:
        java.util.Iterator.Iterator 接口也是Java集合中的一员,但它与Collection,Map 接口有所不同，
        Collection接口与Map接口主要用于存储元素,
        而Iterator主要用于迭代访间(即遍历)Collection中的元素，因此Iterator对象也被称为迭代器.

想要遍历Collection集合,那么就要获取该集合迭代完成迭代操作,
        下面介绍一下获取迭代器的方法:
            1.public Iterator Iterator():获取集合对应的迭代器,用来遍历集合中的元素的。
        下面介绍一下迭代的概念:
            2.迭代:即collection集合元素的通用获取方式。在取元素之前先要判断集合中有没有元素如果有,就把这个
            元素取出来,继续在判断,如果还有就再取出出来。- -直把集合中的所有元素全部取出。这种取出方式专业术
            语称为迭代。

接口的常用方法如下:
        public E next():返回迭代的下一个元素。取出集合中的下一个元素
        public boolean hasNext():判断集合中还有没有下一个元素,
          如果仍有元素可以迭代，则返回 true。没有则返回false

Collection接口中有一个方法叫Iterator,这个方法返回的就是选代器的实观类对象
Iterator<E> Iterator()返回在此,Collection的元素上进行选代的迭代器。

迭代器的使用步骤:
     1.先使用集合中的方法Iterator()获取迭代器的实现类对象,使用Iterator接口接受(多态)
     2.使用Iterator接口中的方法hasNext()判断还有没有下一个元素
     3.使用Iterator按口中的方法nex取出集合中的下一个元素。

*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Iterator迭代器 {
    public static void main(String[] args) {
//      创建一个集合对象
        Collection<String> collection = new ArrayList<>();
        collection.add("姚明");
        collection.add("科比");
        collection.add("麦迪");
        collection.add("詹姆斯");
        collection.add("艾佛森");

/*      1.使用集合中的方法Iterator()获取迭代器的实现类对象,使用Iterator接口接受(多态)
            注意:Iterator<E>接口也是有泛型的,迭代器的泛型跟着集合走,集合是什么泛型,迭代器就是什么泛型
*/
//      多态      接口             实现类对象
        Iterator<String> iterator = collection.iterator();
/*

//      2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
        boolean b = iterator.hasNext();
        System.out.println(b);
//      3.使用Iterator接口中的next()方法取出集合中的下一个元素
        String s = iterator.next();
        System.out.println(s);

        b = iterator.hasNext();
        System.out.println(b);
        s = iterator.next();
        System.out.println(s);

        b = iterator.hasNext();
        System.out.println(b);
        s = iterator.next();
        System.out.println(s);

        b = iterator.hasNext();
        System.out.println(b);
        s = iterator.next();
        System.out.println(s);

        b = iterator.hasNext();
        System.out.println(b);
        s = iterator.next();
        System.out.println(s);

        b = iterator.hasNext();
        System.out.println(b);//没有元素,返回false
        s = iterator.next();
        System.out.println(s);//NoSuchElementException
*/

/*发现使用迭代器比出集合中元景的代冯，是一个重复的过程
所以我们可以使用循环忧化
不知道集合中有多步元康、，wile请环
循环不结束的务条hasNext方法近回false
 */
        while (iterator.hasNext()) {
            String e = iterator.next();
            System.out.println(e);
        }
        System.out.println("=========================");

        for (Iterator<String> iterator2=collection.iterator();iterator2.hasNext();){
            String e = iterator2.next();
            System.out.println(e);
        }

    }
}