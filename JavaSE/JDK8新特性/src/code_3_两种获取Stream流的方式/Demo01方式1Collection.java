package code_3_两种获取Stream流的方式;

import java.util.*;
import java.util.stream.Stream;

/*
javo.util.stream. Stream<T>是Jova 8新加入的最常用的流接口。(这并不是一 一个函数式接口。)
        获取一个流非常简单,有以下几种常用的方式:
        .所有的Collection集合 都可以通过stream嘿认方法获取流;
default Stream<E> stream ()
        - Stream接口的静态方法of可以获职数组对应的流。
static <T> Stream<T> of (T... values)
        参数是一个可变参数,那么我们就可以传递一-个数组

*/
public class Demo01方式1Collection {
    public static void main(String[] args) {
        //把集合转换成stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String, String> map = new HashMap<>();
        //获取键存储到一个Set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();

        //获取值存储到一个Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        //获取键值对(键值对的映射关系,entrySet)
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();


        //把数组转换为Stream流
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 6, 7);
        //可变参数可以传递数组
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Stream<Integer> stream7 = Stream.of(arr);
        String[] arr2 = {"a", "bb", "ccc"};
        Stream<String> stream8 = Stream.of(arr2);


    }
}

class Demo02Stream_forEach {
    /* Stream流中的常用方法forEach遍历
     void forEach(Consumer<? super T> action);
     该方法接收- -个Consumer接口函数，会将每一-个流元素交给该函数进行处理。
     Consumer接口是-一个消费型的函数式接口，可以传递Lambda表达式，消费数据
     简单记:
     forEach方法,用来遍历流中的数据
     是一个终结方法，遍历之后就不能继续调用Stream流中的其他方法
 */

    public static void main(String[] args) {
        //获取一个Stream流
        //Stream<String> stream = Stream.of("战三", "李四", "王五", "汪满青");
        //使用Stream的forEach方法遍历

        /*stream.forEach((String name)->{
            System.out.println("name = " + name);
        });*/

        //stream.forEach(name -> System.out.println("name = " + name));


        /*
        Stream流中的常用方法filter:;用于对Stream流中的数据进行过滤
        Stream<T> filter(Predicate<? super T> predicate);
        filter方法的参数Predicote是一一个函数式接口，所以可以传递L ombda表达式,对数据进行过滤
        Predicate中的抽象方法:
        boolean test(T t);
        */


        //Stream<String> stream1 = stream.filter(name -> name.startsWith("汪"));
        //stream1.forEach(name -> System.out.println(name));

    }
}

class Demo03Stream_map {
    /*
    如果需要将流中的元素映射到另-一个流中，可以使用map方法.
            <R> Stream<R> map(Function<? super T, ? extends R> mopper);
    该接口需要一个Function函数式接口参数，可以将当前流中的类型数据转换为另- -种类型的流。
    Function中的抽象方法:
    R apply(T t);
    */
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        Stream<Integer> stream2 = stream1.map((String s) -> {
            return Integer.parseInt(s);
        });
        stream2.forEach(i -> System.out.println(i));

    }
}

class Demo04Stream_count {
    public static void main(String[] args) {
        /*Stream流中的常用方法count:用于统计Stream流中元素的个数

        Long count();
        count方法是一一个终结方法,返回值是一-个long类型的整数
        所以不能再继续调用Stream流中的其他方法了*/

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println("count = " + count);
    }

}

class Demo05Stream_limit {
    /*
    Stream流中的常用方法_limit:用于截取流中的元素

    limit方法可以对流进行截取，只取用前个。方法签名:
    Stream<T> limit(long maxsize);
    参数是一个Long型,如果集合当前长度大于参数则进行截取;否则不进行操作
    limit方法是一一个延迟方法,只是对流中的元素进行截取,返回的是一一个新的流 所以可以继续调用Stream流中的其他方法
    */

    public static void main(String[] args) {
        //获取一个stream流
        String[] arr = {"战三", "李四", "王五", "汪满青"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> limit = stream.limit(3);
        limit.forEach((i -> System.out.println("i = " + i)));
    }
}

class Demo06Stream_skip {
    /*Stream流中的常用方法skip:用于跳过元素
    如果希望跳过前几个元素,可以使用skip方法获取-一个截取之后的新流:
            Stream<T>. skip(long n);
    如果流的当前长度大于n,则跳过前个;否则将会得到一个长度为的空流。*/
    public static void main(String[] args) {
        String[] arr = {"战三", "李四", "王五", "汪满青"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> stream1 = stream.skip(2);
        stream1.forEach(i -> System.out.println("i = " + i));
    }
}

class Demo07Stream_concat {
    public static void main(String[] args) {
        /*Stream流中的常用方法.concat;用于把流组合到一起
                如果有两个流,希望合并成为一一个流,那么可以使用Stream接口的静态方法concat
        stotic <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
*/
        Stream<String> stream1 = Stream.of("战三", " 李四", "王五", "汪满青");
        String[] arr = {"战三", "李四", "王五", "汪满青"};
        Stream<String> stream2 = Stream.of(arr);
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(i -> System.out.println("i = " + i));
    }
}


class 集合元素处理 {
    /*
    现在有两个Araylist集合存储队伍当中的多个成员姓名,要求使用传统的for循环(或增强for{循环)依次进行以
    下若干操作步骤:
    1.第一个队伍只要名字为3个字的成员姓名;存储到一一个新集合中。
    2.第一个队伍筛选之后只要前3个力;存储到- -个新集合中。
    3.第二个队伍只要姓张的成员姓名;存储到- -个新集合中。
    4.第二个队伍筛选之后不要前2个人;存储到- -个新集合中。
    5.将两个队伍合并为-一个队伍 ;存储到- -个新集合中。
    6.根据姓名创建Person对象;存储到一-个新集合中。
    7.打印整个队伍的Person对象信息。
    */
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("诸葛亮");
        one.add("诸葛1");
        one.add("诸葛2");
        one.add("诸葛村");
        one.add("关羽");
        one.add("赵云");
        one.add("张飞");
        one.add("黄忠");
        one.add("马超");
        //1.第一个队伍只要名字为3个字的成员姓名;存储到一一个新集合中。
        ArrayList<String> one1 = new ArrayList<>();
        for (String s : one) {
            if (s.length() == 3) {
                one1.add(s);
            }
        }
        //2.第一个队伍筛选之后只要前3个力;存储到- -个新集合中。
        ArrayList<String> one2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one2.add(one1.get(i));
        }


        //第二只队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("张无忌啊");
        two.add("张三丰");
        two.add("真人");
        two.add("张之洞阿道夫");
        two.add("张学友");
        two.add("张树林");
        //3.第二个队伍只要姓张的成员姓名;存储到- -个新集合中。
        ArrayList<String> two1 = new ArrayList<>();
        for (String s : two1) {
            if (s.startsWith("张")) {
                two1.add(s);
            }
        }
        //4.第二个队伍筛选之后不要前2个人;存储到- -个新集合中。
        ArrayList<String> two2 = new ArrayList<>();
        for (int i = 2; i < two1.size(); i++) {
            two2.add(two1.get(i));//i不包含0和1
        }
        //5.将两个队伍合并为-一个队伍 ;存储到- -个新集合中。
        ArrayList<String> all = new ArrayList<>();
        all.addAll(one2);
        all.addAll(two2);

        //    6.根据姓名创建Person对象;存储到一-个新集合中。
        ArrayList<Person> list = new ArrayList<>();
        for (String name : all) {
            list.add(new Person(name));
        }

        //    7.打印整个队伍的Person对象信息。
        for (Person person : list) {
            System.out.println(person);
        }
    }
}

class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


class 集合元素处理_stream {

    //第一支队伍
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋云桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //1.第一个队伍只要名字为3个字的成员姓名;存储到一一个新集合中。
        //2.第一个队伍筛选之后只要前3个力;存储到- -个新集合中。
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯凯奇");
        two.add("张天爱");
        //3.第二个队伍只要姓张的成员姓名;存储到- -个新集合中。
        //4.第二个队伍筛选之后不要前2个人;存储到- -个新集合中。
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);
        //5.将两个队伍合并为-一个队伍 ;存储到- -个新集合中。
        //6.根据姓名创建Person对象;存储到一-个新集合中。
        //7.打印整个队伍的Person对象信息。
        Stream.concat(oneStream, twoStream).map(name -> new Person(name)).forEach(p -> System.out.println(p));
    }

}