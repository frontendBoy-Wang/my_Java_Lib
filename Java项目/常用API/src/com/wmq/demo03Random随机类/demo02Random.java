package com.wmq.demo03Random随机类;

import java.util.Random;

public class demo02Random {
    public static void main(String[] args) {
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int num=r.nextInt(1000);//范围0-9
            System.out.print(num);
        }
    }


}
