package cn.课堂学习.面向对象.封装;

public class Test {
    public static void main(String[] args) {

        Student student = new Student();
        student.setId(101);
        student.setName("汪满青");
        student.setSex('男');
        student.setAge(20);
        student.setPhone(123456);
        student.setQq(123456);

        System.out.println("学号:" + student.getId());
        System.out.println("姓名:" + student.getName());
        System.out.println("性别:" + student.getSex());
        System.out.println("年龄:" + student.getAge());
        System.out.println("电话:" + student.getPhone());
        System.out.println("QQ:" + student.getQq());

        System.out.println("----------------------");
        System.out.println(student.toString());
//使用构造方法
        Student wmq = new Student(100, "汪", '男', 12, 13, 12313);
        System.out.println(wmq.toString());
    }
}
