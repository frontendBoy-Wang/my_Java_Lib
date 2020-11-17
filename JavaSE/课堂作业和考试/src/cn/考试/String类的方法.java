package cn.考试;

/*
在main0方法中创建字符串str1= "hello world"; str2=new String("123"), 要求完成以下功能:
1)计算并输出字符串str1和str2的长度;
2)比较并输出两个字符串的大小
3)拼接并输出两个字符串;
4)分别用"=="和equal方法判断并输出字符串值是否相等
5)截取字符串str1,输出"hello";


 */
public class String类的方法 {
    public static void main(String[] args) {
        String str1 = "hello world";
        String str2 = new String("123");

//        1)计算并输出字符串str1和str2的长度;
        System.out.println("字符串str1的长度：" + str1.length());
        System.out.println("字符串str2的长度：" + str2.length());

//       2)比较并输出两个字符串的大小
        System.out.println(str1.compareTo(str2));

//        3)拼接并输出两个字符串;
        String str3 = str1 + str2;
        str3 = str1.concat(str2);
        System.out.println("拼接后的新字符串：" + str3);

//        4)分别用"=="和equal方法判断并输出字符串值是否相等
        if (str1 == str2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (str1.equals(str2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

//        5)截取字符串str1,输出"hello";
        System.out.println(str3.substring(0,5));
    }
}
