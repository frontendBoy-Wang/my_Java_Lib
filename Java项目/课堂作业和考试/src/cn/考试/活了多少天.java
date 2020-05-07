package cn.考试;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*题目:计算自己活了多少天:
 *1.将字符串转换成日期类型
 *2.获取当前的日期
 *3.将出生日期和当前日期转换成毫秒值相减,再转换成天数输出!*/


public class 活了多少天 {
    public static void main(String[] args) throws ParseException {

        String birthdayString = "2001-01-06";
        System.out.println("我的生日是:" + birthdayString);
//		将字符串转换为date类型
        SimpleDateFormat StoDate = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = StoDate.parse(birthdayString);

//		获取当前日期
        Date nowDate = new Date();

//      当前日期转换为毫秒值
        long nowSecond = nowDate.getTime();
//      出生日期转换成毫秒值
        long birthdaySecond = birthdayDate.getTime();
//        当前日期的毫秒值减去出生日期的毫秒值
        long second = nowSecond - birthdaySecond;
        System.out.println("我已经活了:" + second / 1000 / 60 / 60 / 24 + "天");

    }
}