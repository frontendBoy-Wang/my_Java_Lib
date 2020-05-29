package fanshe;

public class Demo01Reflect {
    /**
     * 获取Class对象的方式:
     * 1. Class.forName("全类名"):将字节码文件加载进内存,返回Class对象;
     * 2. 类名.class:通过类名的属性class获取
     * 3. 对象.getClass():getClass()方法在Object类中定义着
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName("全类名")
        Class cls1 = Class.forName("fanshe.Person");
        System.out.println("cls1 = " + cls1);
        //2.类名.class
        Class cls2 = Person.class;
        System.out.println("cls2 = " + cls2);
        //3. 对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println("cls3 = " + cls3);

        //==比较三个对象
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }

}

class Person {
    private String name;
    private int age;

    public String a;
    protected String b;
    String c;
    private String d;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
    public void eat(){
        System.out.println("eat...");
    }
    public void eat(String foot){
        System.out.println("eat..."+foot);
    }

}
