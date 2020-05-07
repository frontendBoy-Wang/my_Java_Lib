package cn.作业;

/*
1.创建一个Goods商品类，请完成如下操作:
        一,声明公有属性:
            1)id(编号), name(名称), price(价格) , number(数量)
        2.声明公有方法:
            1)设置商品参数的方法setGoodsInfo()
            2)获取商品参数的方法getGoodsInfo()

        二,创建一个Test测试类,在main方法中完成如下操作:
        1.实例化商品对象
        2.调用setGoodsInfo()方法，设置该商品的参数
        3.调用getgoodsInfo()方法，输出该商品的参数*/
public class Goods {
    public int id;
    public String name;
    public double price;
    public int number;

    public Goods() {
    }

    public Goods(int id, String name, double price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }
/*
    public void setGoodsInfo(int id, String name, double price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }*/

    public void getGoodsInfo() {
        System.out.println
                ("编号:" + this.id + "\n名称:" + this.name + "\n价格:" + this.price + "\n数量:" + this.number);
    }
}
