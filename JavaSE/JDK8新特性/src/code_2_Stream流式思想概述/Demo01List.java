package code_2_Stream流式思想概述;

import java.util.ArrayList;
import java.util.List;

public class Demo01List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("wmq1");
        list.add("awmq2adf");
        list.add("qmq3");
        list.add("wmq4");

        List<String> listA = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("w")) {
                listA.add(s);
            }
        }
        List<String> listB = new ArrayList<>();
        for (String s : listA) {
            if (s.length() == 4) {
                listB.add(s);
            }
        }
        for (String s : listB) {
            System.out.println("s = " + s);
        }
        show();
    }

    //使用stream流,Lambda表达式
    private static void show() {
        List<String> list1 = new ArrayList<>();
        list1.add("wmq1");
        list1.add("awmq2adf");
        list1.add("qmq3");
        list1.add("wmq4");
        list1.stream()
                .filter(name -> name.startsWith("w"))
                .filter(name -> name.length() == 4)
                .forEach(name -> System.out.println(name));
    }


}
