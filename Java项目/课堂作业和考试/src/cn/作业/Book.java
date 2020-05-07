package cn.作业;

/*
(抽象类)
创建包: com.hbzy.edu.stu， 完全如下操作:
1、建立抽象类Book,提供封装属性bookName,num,price及对应的getter/setter方法;
2、在抽象类中提供printTotalPrice抽象方法;
3、建立子类ComputerBook,
提供封装bookName、 num、 price及属性对应的getter/setter方法，
并重写父类中的printTotalPrice方法实现按照数量和折扣计算出总金额。
*/
public abstract class Book {
    //  1、建立抽象类Book,提供封装属性bookName,num,price及
    private String bookName;
    private int num;
    private double price;

    //封装属性,对应的getter/setter方法;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }

    //    2、在抽象类中提供printTotalPrice抽象方法;
    public abstract double printTotalPrice(String bookName, int num, double price);
}

/*3、建立子类ComputerBook,
    提供封装bookName、 num、 price及属性对应的getter/setter方法，
    并重写父类中的printTotalPrice方法实现按照数量和折扣计算出总金额。*/
class ComputerBook extends Book {
    private String bookName;
    private int num;
    private double price;

    public ComputerBook() {
    }

    public ComputerBook(String bookName, int num, double price) {
        this.bookName = bookName;
        this.num = num;
        this.price = price;
    }

    @Override
    public String getBookName() {
        return bookName;
    }

    @Override
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double printTotalPrice(String bookName, int num, double price) {
        this.bookName = bookName;
        this.num = num;
        this.price = num * price;
        if (this.price <= 0) {
            System.out.println("单价要大于0");
        }
        if (this.num <= 0) {
            System.out.println("数量要大于0");
        } else if (this.num > 0 && this.num < 10) {
            this.price = this.num * this.price;
        } else if (this.num > 10 && this.num < 20) {
            this.price = this.num * this.price * 0.9;
        } else if (this.num >= 20 && this.num < 100) {
            this.price = this.num * this.price * 0.8;
        } else {
            this.price = this.num * this.price * 0.5;
        }

        System.out.println("我买了" + this.num + "本" + this.bookName + "\n总价是:" + this.price);
        return this.price;
    }
}

class test {
    public static void main(String[] args) {
        Book book = new ComputerBook();
        book.printTotalPrice("java从入门到精通", 10, 25);
    }
}
