package com.Map集合;

//Map接口：(无序，不重复)  HashMap（键，值可以为null） HashTable（键、值不能为null）

//Map map=new HashMap();

//添加：put(key,value)  map.put("e1001",emp1);  map.put(1,emp1); map.put(1,123);...
//删除：remove(key)	map.remove("e1001");
//获取键的集合：keySet()  map.keySet(); //{"e1001","e1002"...}
//获取值的集合：values()  map.values(); //{emp1,emp2,emp3...}

//泛型机制：
//1.限制集合中只能存储整型数据：List<Integer> list=new ArrayList<Integer>();
//2.限制集合中只能按照"String,Employee"的方式来存储数据：Map<String,Emloyee> map=new HashMap<String,Employee>();


import java.util.Hashtable;
import java.util.Map;

class Employee {
    private String empNo;
	private String empName;
	private char empSex;
	private int empAge;

	public Employee() {
	}

	public Employee(String empNo, String empName, char empSex, int empAge) {
		this.empNo = empNo;
		this.empName = empName;
		this.empSex = empSex;
		this.empAge = empAge;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public char getEmpSex() {
		return empSex;
	}

	public void setEmpSex(char empSex) {
		this.empSex = empSex;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
}

public class MapDemo {

    public static void main(String[] args) {

        //泛型机制：限制集合不能存放任意类型的数据
        //list接口 map接口相关集合    ===>数组：元素的类型必须一致


        Employee emp1 = new Employee("e1001", "john", '男', 28);
        Employee emp2 = new Employee("e1002", "jerry", '女', 24);
        Employee emp3 = new Employee("e1003", "tom", '男', 33);
        Employee emp4 = new Employee("e1004", "mary", '女', 26);
        Employee emp5 = new Employee("e1005", "mike", '男', 30);
        // 创建map接口对象==>子类 HashMap hashtable来实现
        Map<Integer, Employee> map = new Hashtable<Integer, Employee>();
        //Map map = new Hashtable();
        // 以键值对形式存储数据
        map.put(1, emp1);//键值对（主键，对象） Object<==Employee
        map.put(2, emp2);//(String,Employee)
        map.put(3, emp3);
        map.put(4, emp4);
        map.put(5, emp5);
        map.put(6, emp5);

        //map.replace("e1002", emp5);
        //map.replace("e1003", emp2);
        //map.remove("e1002");

        //获取集合中某个元素
        //System.out.println(map.get("e1001"));
        //获取键的集合
        //map.keySet();
        //获取值的集合
        //map.values();
        //遍历集合，输出所有员工的编号 主键值
        //for (Object object:map.keySet()) {
        //	System.out.println(object);
        //}


        //Object是所有类型的父类int double String 自定义的类

        //遍历集合，输出所有员工的信息
        for (Object object : map.values()) {//{Object,Object,Object,Object}
            //将对象类型转换成员工类型
            Employee employee = (Employee) object;
            System.out.print(employee.getEmpNo() + "\t" + employee.getEmpName() + "\t" + employee.getEmpSex() + "\t" + employee.getEmpAge());
            System.out.println();//换行
        }


        //主键：非空不重复


    }

}
