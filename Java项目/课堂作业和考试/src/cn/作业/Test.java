package cn.作业;
//  二,创建一个Test测试类,在main方法中完成如下操作:
//          1.实例化商品对象
//          2.调用setGoodsInfo()方法，设置该商品的参数
//          3.调用getGoodsInfo()方法，输出该商品的参数
public class Test {
    public static void main(String[] args) {
        Goods goods=new Goods(12,"wmq",12.9,10);
        goods.getGoodsInfo();
    }


}
