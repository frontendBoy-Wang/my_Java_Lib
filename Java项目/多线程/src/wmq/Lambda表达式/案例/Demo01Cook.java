package wmq.Lambda表达式.案例;
/*
需求:
        给定一个厨子Cook接口内含唯一-的抽象方法mokeFood, 且无参数、无返回值。
        使用Lambda的标准格式调用invoKeCook方法，打印输出吃饭啦!字样
*/

public class Demo01Cook {
    public static void main(String[] args) {
        invoKeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭啦!");
            }
        });

        //使用Lambda表达式简化匿名内部类的书写
        invoKeCook(()->{
            System.out.println("吃饭了Lambda");
        });
        
        //优化省略
        invoKeCook(()->  System.out.println("吃饭了Lambda优化"));
    }


    //定义一个方法 参数传递Cook接口.方法内部调用cook接口中的方法
    public static void invoKeCook(Cook cook){
        cook.makeFood();
    }
}

