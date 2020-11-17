package cn.课堂学习.面向对象.封装;

/*
1.在其中创建Student类
包含
id (学号) 、
name (姓名)、
sex (性别)、
age (年龄)、
phone (手机)
qq (QQ)等属性。
请使用getXXX0和setXXX(方法对所有属性进行封装。
2.创建Test类，在其main方法中实例化对象，调用getXXX0和setXXX0实现学生对象的属性设置并输出。
 */
public class Student {
    private int id; //(学号) 、
    private String name; //(姓名)、
    private char sex;//(性别)、
    private int age; //(年龄)、
    private int phone; //(手机)
    private int qq;//QQ

    public Student() {
    }

    public Student(int id, String name, char sex, int age, int phone, int qq) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.qq = qq;
    }

    //    使用getXXX0和setXXX(方法对所有属性进行封装
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }


    @Override
    public String toString() {
        return "学生:" +
                "\n学号=" + id +
                "\n姓名=" + name +
                "\n性别=" + sex +
                "\n年龄=" + age +
                "\n电话=" + phone+
                "\nQQ="+qq;
    }
}
