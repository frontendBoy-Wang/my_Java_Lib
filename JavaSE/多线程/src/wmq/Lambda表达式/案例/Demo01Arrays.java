package wmq.Lambda表达式.案例;
/*
Lambda表达式有参数有返回值的练习
        需求:
        使用数组存储多个Person对象
        对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
*/

import java.util.Arrays;
import java.util.Comparator;

public class Demo01Arrays {
    public static void main(String[] args) {
        //使用数组存储多个Person对象
        Person[] arr = {
                new Person("wmq1", 38),
                new Person("wmq2", 18),
                new Person("wmq3", 19)
        };

        //对数组中的Person对象使用Arrays的sort方法通过年龄进行升序(前边-后边)排序
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        //使用Lambda表达式,简化内部类
        /*Arrays.sort(arr,(Person o1,Person o2)->{
            return o1.getAge()-o2.getAge();
        });*/
        //省略写法
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());


        //遍历数组
        for (Person person : arr) {
            System.out.println("person = " + person);
        }
    }

}
