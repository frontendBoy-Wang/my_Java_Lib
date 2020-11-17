package cn.课堂学习.String;

public class String类 {

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "Hello World!";
        System.out.println(s1.substring(1, 5));
        if (s1 == s2) {
            System.out.println("相等");
        } else {
            System.out.println("不等");
        }
        StringBuffer stringBuffer = new StringBuffer();
//        添加字符串
        stringBuffer.append("123");
        System.out.println(stringBuffer);
        stringBuffer.insert(1, "abcd");
        System.out.println(stringBuffer);

        stringBuffer.setCharAt(4, 'H');
        System.out.println(stringBuffer);
        System.out.println("=========================");

        /*String s1="1234";//不能通过new String()来创建
		String s2=new String("1234");
		if(s2.equals(s1)){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
		//如果要进行字符串间相等比较，请不要使用"=="，而是使用s1.equals(s2)


		String s1="12345";//52
		String s2="123a";//97
		System.out.println(s1.compareTo(s2));

		//length()   s1.length()
		//valueOf() String.valueOf(非字符串类型)：其它类型转换成为字符串
		//concat(): +
		//equals:字符串相等比较 s1.equals(s2) true/false
		//compareTo:字符串大小比较 s1.compareTo(s2) 正  0 负
		//subString():s1.subString(起始，起始+长度)

		*/


        //StringBuffer类的使用
        StringBuffer str1 = new StringBuffer();
        System.out.println(str1);
        //添加
        str1.append("123");
        System.out.println(str1);
        //在当前索引位置之前插入字符
        str1.insert(1, "abcd");
        System.out.println(str1);
        //替换指定索引位置的单个字符
        str1.setCharAt(4, '4');
        System.out.println(str1);
        str1.reverse();
        System.out.println(str1);
        str1.replace(0, 3, "abc");
        System.out.println(str1);


		/*Random random=new Random();
		random.nextInt(100);//[0,99]

		0<=Math.random()<1;//[0,1)
		0<=Math.random()*100<100;[0,100)
		0<=(int)(Math.random()*100)<=99;[0,99]
		*/
    }
}
