package cn.课堂学习.面向对象.多态.抽象类;

public abstract class Shape {
    public abstract void Area(double x, double y);
}

class Triangle extends Shape {
    public void Area(double x, double y) {
    }
}

class Rectangle extends Shape {
    public void Area(double x, double y) {
    }
}