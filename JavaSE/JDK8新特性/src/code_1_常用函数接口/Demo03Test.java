package code_1_常用函数接口;
/*
丞数式接口的使用:一般可以作为方法的参数和返回值类型
*/

public class Demo03Test {
    //定义一个方法参数使用函数式接口Demo01FunctionalInterface
    public static void show(Demo01FunctionalInterface myInter){
        myInter.method();
    }

    public static void main(String[] args) {
        //调用show方法,方法的参数是一个接口,可以传递接口的实现类对象
        show(new Demo02FunctionalInterfaceImpl());

        //调用show方法,方法的参数是一个接口,可以传递接口的匿名内部类
        show(new Demo02FunctionalInterfaceImpl(){
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });
        //调用show方法,方法的参数是一个函数式接口,可以用lambda表达式
        show(()->{
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });
    }
}
