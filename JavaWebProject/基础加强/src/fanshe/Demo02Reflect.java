package fanshe;

import java.lang.reflect.Field;

public class Demo02Reflect {
    /*


     * Class对象功能:
     * 获取成员变量
     * Field[] getFields()
     * Field getField(String name)

     * Field[] getDeclaredFields()
     * Field getDeclaredField(String name)
     * 获取构造方法
     * Constructor<?>[] getConstructors()
     * Constructor<T> getConstructor(类<?>... parameterTypes)

     * Constructor<?>[] getDeclaredConstructors()
     * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
     * 获取成员方法
     * Method[] getMethods()
     * Method getMethod(String name, 类<?>... parameterTypes)

     * Method[] getDeclaredMethods()
     * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
     * 获取类名
     * String getName()
     */
    public static void main(String[] args) throws Exception {
        //获取Person的Class对象
        Class personClass = Person.class;
        /*获取成员变量
         * Field[] getFields()
         * Field getField(String name)

         * Field[] getDeclaredFields()
         * Field getDeclaredField(String name)*/

        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        System.out.println("=============");
        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object valus = a.get(p);
        System.out.println("valus = " + valus);
        //设置a的值
        a.set(p,"汪满青");
        System.out.println(p);

        // Field[] getDeclaredFields()获取所有的成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
        // Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println("value2 = " + value2);
    }

}
