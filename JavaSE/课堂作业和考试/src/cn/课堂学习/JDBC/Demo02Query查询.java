package cn.课堂学习.JDBC;

import java.sql.*;

/*
查询步骤:
    //1.加载驱动
    Class.forName(driver);
    //2.创建连接对象
            conn=DriverManager.getConnection(url,user,password);
    //3.创建声明对象
            st=conn.createStatement();
    //4.声明命令字符串（查询）
            String sql="select * from users";
    //5.声明对象调用“执行查询”方法，其结果存入结果集
            rs=st.executeQuery(sql);
    //6.遍历结果集
            while(rs.next()){
            System.out.println(rs.getObject("id")+"\t"+rs.getObject("username")+"\t"+rs.getObject("password"));
            }

增删改步骤
    //1.加载驱动

    //2.创建连接对象

    //3.创建声明对象

    //4.声明命令字符串（增删改）
            String sql="insert users values('john','123')";
    //5.声明对象调用“执行更新方法”
            st.executeUpdate(sql);

*/
public class Demo02Query查询 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            //加载驱动
            Class.forName(driver);
            //获取连接
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName = Xk", "sa", "123");
            String sql = "SELECT * from Student";
            //3.发送sql语句
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
           /* while (rs.next()) {
                System.out.println("name:" + rs.getString(2));
            }*/
            System.out.println("学号\t\t班级号\t\t姓名\t密码");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo02 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName = Xk", "sa", "root");

            //3.发送sql语句
            ps =connection.prepareStatement("SELECT * from Student");

            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("name:"+rs.getString(2));
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
*/