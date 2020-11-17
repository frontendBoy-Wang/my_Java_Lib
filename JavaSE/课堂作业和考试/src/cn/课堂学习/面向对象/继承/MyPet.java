package cn.课堂学习.面向对象.继承;

/*
1.100分问答题 1.编写父类MyPet, 提供如下成员:
1)私有属性:name,ownerName,age,color,weight (体重)方法;
2)公有方法show,输出宠物信息，例如，"阿桂"今年"3"岁 了，是一条"白色“体重"12"公斤的宠物。
3)公有方法speak, 输出一句话，例如，"阿桂会说话，可是主人总是不明白我的意思。
4)公有方法playWithOwner, 输出一句话，例如，"Tom"和他的宠物"阿桂玩得很开心。
2.编写类MyDog继承MyPet，子类沿用父类中的属性，并提供子类私有属性species(类别)。
3.在子类中定义main方法，实例化子类对象，调用父类方法。*/
public class MyPet {
    private String name;
    private String ownerName;
    private int age;
    private String color;
    private double weight;

    public MyPet() {
    }

    public MyPet(String name, String ownerName, int age, String color, double weight) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //2)公有方法show,输出宠物信息，例如，"阿桂"今年"3"岁 了，是一条"白色“体重"12"公斤的宠物。
    public void show() {
        System.out.println(name + "今年" + age + "岁了,是一只" + color + "的" + weight + "斤的宠物!");
    }

    //3)公有方法speak, 输出一句话，例如，"阿桂会说话，可是主人总是不明白我的意思。

    public void speak() {
        System.out.println(name + "会说话，可是主人总是不明白我的意思。");
    }

    //4)公有方法playWithOwner, 输出一句话，例如，"Tom"和他的宠物"阿桂玩得很开心。
    public void playWithOwner() {
        System.out.println(ownerName + "和他的宠物" + name + "玩得很开心。");
    }


}














