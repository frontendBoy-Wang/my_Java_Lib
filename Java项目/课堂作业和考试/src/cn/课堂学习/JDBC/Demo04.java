package cn.课堂学习.JDBC;

import java.sql.*;
import java.util.Scanner;

public class Demo04 {
    //声明驱动字符串
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //声明连接字符串
    static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=Xk";
    static String user = "sa";
    static String password = "123";
    //声明连接(接口)对象
    static Connection conn = null;
    //声明声明对象
    static PreparedStatement pst = null;
    //声明结果集对象
    static ResultSet rst = null;

    public static void main(String[] args) throws SQLException {
        //1.select *from 从键盘输入一个编号,查询对应用户信息
        try {
            //1.加载驱动
            Class.forName(driver);
            //2.驱动管理,加载连接
            conn = DriverManager.getConnection(url, user, password);
            //3.声明条件查询字符串
            System.out.println("输入学生编号:");
            Scanner scanner = new Scanner(System.in);
            String StuNo = scanner.next();
            String sql = "select *from Student where StuNo=?";
            //4.创建预编译声明对象
            pst = conn.prepareStatement(sql);
            //5.预编译声明对象set方法对应占位符与变量值之间的关联
            pst.setObject(1, StuNo);
            //6.预编译声明对象调用"执行查询"方法,将返回的结果存入到结果集中
            rst = pst.executeQuery();

            System.out.println("学号\t\t班级号\t\t姓名\t密码");
            while (rst.next()) {

                System.out.println(rst.getObject("StuNo")
                        + "\t" + rst.getObject("ClassNo")
                        + "\t" + rst.getObject("StuName")
                        + "\t" + rst.getObject("Pwd"));
            }
            scanner.close();
        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
        } finally {
            //关闭连接
            if (conn != null) conn.close();
            if (rst != null) rst.close();
            if (pst != null) pst.close();
        }
    }

}

/*//4.创建预编译声明对象
            pst = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //5.预编译声明对象set方法对应占位符与变量值之间的关联
            pst.setObject(1, StuNo);
            //6.预编译声明对象调用"执行查询"方法,将返回的结果存入到结果集中
            rst = pst.executeQuery();
            System.out.println("学号\t\t班级号\t\t姓名\t密码");
            rst.last();//把指针指向最后
            if (rst.getRow() == 0) {//获取指针指向的当前行的序号
                System.out.println("查无此人!");
            } else {
                while (rst.next()) {
                    rst.beforeFirst();
                    System.out.println(rst.getObject("StuNo")
                            + "\t" + rst.getObject("ClassNo")
                            + "\t" + rst.getObject("StuName")
                            + "\t" + rst.getObject("Pwd"));
                }
            }

 */
