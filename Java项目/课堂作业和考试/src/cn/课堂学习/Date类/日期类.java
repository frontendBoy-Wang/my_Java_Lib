package cn.课堂学习.Date类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 日期类 {
    public static void main(String[] args) throws ParseException {
//        时间类
//        在main0方法中获取当前系统日期，然后按照格式"yyy-MM-dd"输出这-日期。
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String now = sdf.format(today);
        System.out.println("当前日期:"+now);

        System.out.println("===================================");
//      日期格式化逆
        String MyFairy = "2001-1-6";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = simpleDateFormat.format(simpleDateFormat.parse(MyFairy));
        System.out.println("我的小仙女赵琴的生日是:" + birthday);
//        System.out.println("我的小仙女赵琴的生日是:"+simpleDateFormat.parse(MyFairy));

        System.out.println("===================================");
//        日历类
        Calendar rightNow = Calendar.getInstance();//日历对象
        Date date = rightNow.getTime();
        SimpleDateFormat sdf1=new SimpleDateFormat("y年M月d日");
        String today1=sdf1.format(date);
        System.out.println("今天的日期是:"+today1);
        System.out.println("===================================");
        rightNow.add(Calendar.DATE,-1);
        Date yesterday=rightNow.getTime();
        String yestodaystr=sdf.format(yesterday);
        System.out.println("昨天的日期是:"+yestodaystr);

        System.out.println("===================================");
        Date today2=new Date();
        long l = today2.getTime() / (1000 * 3600 * 24);
        System.out.println(l);

        System.out.println("===================================");
//        我活了多少天?1974.9.3-2020-3-9
        String birStr="1999-04-11";
       Date nowStr=new Date();
       nowStr.getTime();
    }
}













