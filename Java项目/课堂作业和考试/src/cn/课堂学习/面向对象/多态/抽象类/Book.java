package cn.课堂学习.面向对象.多态.抽象类;

/*
 *Book方法的重载
 *
 */
public class Book {
    //封装属性
    private String bookName;
    private double price;
    private int num;
    private double totalPrice;

    public Book() {
    }

    public Book(String bookName, double price, int num) {
        this.bookName = bookName;
        this.price = price;
        this.num = num;
        if (this.price <= 0) {
            System.out.println("单价要大于0");
            //this.totalPrice = 0;
        }
        if (this.num <= 0) {
            System.out.println("数量要大于0");
            //this.totalPrice = 0;
        } else if (this.num > 0 && this.num < 10) {
            this.totalPrice = this.num * this.price;
        } else if (this.num > 10 && this.num < 20) {
            this.totalPrice = this.num * this.price * 0.9;
        } else if (this.num >= 20 && this.num < 100) {
            this.totalPrice = this.num * this.price * 0.8;
        } else {
            this.totalPrice = this.num * this.price * 0.5;
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //    主方法
    public static void main(String[] args) {
        Book book = new Book("Java核心思想", 32, -1);
        System.out.println("购买" + book.getNum() + "本" + book.getBookName() + "的总金额是: " + book.getTotalPrice());

        Book book1 = new Book("Java核心思想1", 323, 10);
        System.out.println("购买" + book1.getNum() + "本" + book1.getBookName() + "的总金额是: " + book1.getTotalPrice());

        Book book2 = new Book("Java核心思想2", 320, 100);
        System.out.println("购买" + book2.getNum() + "本" + book2.getBookName() + "的总金额是: " + book2.getTotalPrice());

        Book book3 = new Book("Java核心思想", 302, 4);
        System.out.println("购买" + book3.getNum() + "本" + book3.getBookName() + "的总金额是: " + book3.getTotalPrice());

    }
}


























