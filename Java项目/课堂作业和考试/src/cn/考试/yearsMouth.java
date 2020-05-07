package cn.考试;

import java.awt.*;
import java.util.Scanner;

public class yearsMouth {
    public static void main(String[] args) {

        int days = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = scanner.nextInt();
        System.out.println("请输入月份:");
        int month = scanner.nextInt();
        boolean isYear = false;//默认为平年

        //判断是否为闰年
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println(year + "闰年");
            isYear = true;
        } else {
            System.out.println(year + "非闰年");
            isYear = false;
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 2:
                if (isYear) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                System.out.println("error!!!");
                break;
        }
        System.out.println(year + "年" + month + "月有" + days + "天");

    }
}



