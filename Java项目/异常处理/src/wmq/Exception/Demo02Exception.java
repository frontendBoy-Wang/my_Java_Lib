package wmq.Exception;
/*
      1.访问了数组中的3索引,而数组是没有3索引的，这时候，jVM就会检测出程序会出现异常
        JVM会做两件事情:
        1JVM会根据异常产生的原因创建一个异常对象这个异常对象包含了异常产生的(内容,原因,位置)
        new ArrayIndexOutOfBoundsException("3");:
        2.在getElement方法中,没有异常的处理逻辑(py.catch),那么JVM就会把异常对象抛出给方法的调用者
        main方法来处理这个异常

        --------------->getElement方法把异常对象抛出给main方法

      2.new ArrayIndexOutOfBoundsException("3");
        main方法接收到了这个异常对象main方法也没有异常的处理逻辑
        继续吧对象抛出给main方法的调用者JVM处理

        --------------->main方法把异常对象抛出给JVM

      3.new ArrayIndexOutOfBoundsException("3');
        JVM接收到了这个异常对象,做了两件事情
        1把异常对象(内容,原因位置)以红色的字体打印在控制台
        2JVM会终止当前正在执行的java程---->中断处理

*/
public class Demo02Exception {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int e = getElement(arr,3);
        System.out.println(e);
    }
    /*
        定义一个方法,获取数组指定索引出的元素
        参数:
            int[] arr
            int index
         */
    private static int getElement(int[] arr, int index) {
        int ele=arr[index];
        return ele;
    }


}
