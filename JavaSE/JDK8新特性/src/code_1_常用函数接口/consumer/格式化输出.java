package code_1_常用函数接口.consumer;

import java.util.function.Consumer;

public class 格式化输出 {
    public static void main(String[] args) {
        String[] arr={"wmq1,男","wmq2,男","wmq3,男"};
        PrintInfo(arr,(msg)->{
            String name=msg.split(",")[0];
            System.out.print("name : " + name+",");
        },(msg)->{
            String age=msg.split(",")[1];
            System.out.println("age : " + age);
        });

    }

    private static void PrintInfo(String[] arr, Consumer<String>con1,Consumer<String>con2) {

        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }



    }
}
