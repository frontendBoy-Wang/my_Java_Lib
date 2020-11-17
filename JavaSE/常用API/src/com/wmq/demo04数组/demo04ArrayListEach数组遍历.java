package com.wmq.demo04数组;

import java.util.ArrayList;

public class demo04ArrayListEach数组遍历 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("迪丽热巴");
        list.add("汪满青");
        list.add("赵琴");

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
