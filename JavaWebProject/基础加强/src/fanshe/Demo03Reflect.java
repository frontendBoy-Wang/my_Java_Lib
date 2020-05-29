package fanshe;

import java.lang.reflect.Constructor;

public class Demo03Reflect {
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
         * 获取构造方法
         * Constructor<?>[] getConstructors()
         * Constructor<T> getConstructor(类<?>... parameterTypes)

         * Constructor<?>[] getDeclaredConstructors()
         * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         * */

        // Constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println("constructor = " + constructor);
        //创建对象
        Object zhang = constructor.newInstance("zhang", 23);
        System.out.println("zhang = " + zhang);
    }

}
