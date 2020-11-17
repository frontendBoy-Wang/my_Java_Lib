package cn.课堂学习.面向对象.封装;

public class Goods {
    //1.封装属性
    private String id;
    private String name;
    private double price;
    private int number;

    public Goods(String id, String name, int i, int i1) {

    }

    public Goods(String id, String name, double price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        if (number >= 0) {
            this.number = number;
        } else {
            this.number = 0;
        }
    }

    public Goods() {

    }

    //2.提供一组公有的方法的访问封装属性
    //2.1设置商品的编号:id--->用户提供一个编号将这个数值赋值给id


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
//        对用户提供的数据进行限制
        if (number >= 0) {
            this.number = number;
        } else {
            this.number = 0;
        }

    }

    @Override
    public String toString() {
        return
                "编号='" + id + '\'' +
                        ", 名称='" + name + '\'' +
                        ", 价格=" + price +
                        ", 数量=" + number;
    }
}
