package com.Map集合.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    HashMop存储自定义类型键值
    Map集合保证key是唯一的:
    作为key的元素,必须重写hashCode方法和equals方法,以保证key唯一
*/
public class Demo04HashMap存储自定义键值对 {
    public static void main(String[] args) {
        show02();
    }

    /*
        HashMop存储自定义类型键值
        key:Person类型.
        Person类就必须重写hashCode方法和equals方法，以保证key唯一
        value:String类型
        可以重复
    */
    private static void show02() {
        //创建HashMap集合
        HashMap<Person, String> map = new HashMap<>();
        //添加元素
        map.put(new Person("女王",18),"英国");
        map.put(new Person("秦始皇",18),"秦国");
        map.put(new Person("普京",30),"俄罗斯");
        map.put(new Person("女王",18),"毛里求斯");
        Set<Map.Entry<Person,String>> set=map.entrySet();
        for (Map.Entry<Person, String> entry : set) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "--->" + value);
        }
    }

//    HashMap存储自定义类型键值
//    key:String类型
//    string类重写hashCode方法和equals方法，可以呆证key唯一

    private static void show() {
        //创建HashMap集合
        HashMap<String, Person> map = new HashMap<>();
        //添加元素
        map.put("北京", new Person("张三", 18));
        map.put("上海", new Person("李四", 19));
        map.put("广州", new Person("王五", 20));
        map.put("深圳", new Person("赵六", 21));
        //使用KeySet加强监督for遍历Map集合
        Set<String> set = map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key + "--->" + value);
        }
    }
}
