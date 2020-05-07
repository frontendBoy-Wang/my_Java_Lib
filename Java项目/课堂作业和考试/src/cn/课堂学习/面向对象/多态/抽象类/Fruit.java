package cn.课堂学习.面向对象.多态.抽象类;

public abstract class Fruit {
    //抽象的方法
    public abstract void plant(Fruit fruit);

    public abstract void setName(String name);

    public abstract String getName();
}


class Apple extends Fruit {

    //封装属性
    private String name;

    public void plant(Fruit fruit) {
        System.out.println("种植" + fruit.getName());
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        this.name=name;
        return name;
    }

    public static void main(String[] args) {
        Fruit fruit = new Apple();
        fruit.setName("苹果");
        fruit.plant(fruit);
    }
}
