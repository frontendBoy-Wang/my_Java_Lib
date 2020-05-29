package fanshe;

import java.lang.reflect.Method;

public class Demo04Reflect {
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
        /*
         * 获取成员方法
         * Method[] getMethods()
         * Method getMethod(String name, 类<?>... parameterTypes)

         * Method[] getDeclaredMethods()
         * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         * */

        //获取指点名称的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        //执行方法
        eat_method.invoke(p);

        Method eat_mehtod2 = personClass.getMethod("eat", String.class);
        //执行方法
        eat_mehtod2.invoke(p, "fan");
        System.out.println("+++++++++++++++++++++++");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取类名
        String className = personClass.getName();
        System.out.println("className = " + className);

    }
}
