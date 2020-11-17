package jdbc;

import java.sql.*;

/**
 * JDBC快速入门
 * 详解各个对象:
 * 1. DriverManager :驱动管理对象
 * 2. Connection :数据库连接对象
 * 3. Statement :执行sql的对象
 * 4. ResultSet :结果集对象
 * 5. PreparedStatement :
 */
public class Demo01JDBC快速入门 {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql:///db1";
    static String user = "root";
    static String pwd = "wmq12138";

    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName(driver);
        //3.获取连接对象
        Connection conn = DriverManager.getConnection(url, user, pwd);
        //4.定义SQL语句
        String sql = "update account set balance=2500 where id=1";
        //5.执行SQL对象Statemaent
        Statement stmt = conn.createStatement();
        //6.执行sql
        int result = stmt.executeUpdate(sql);
        //7.c处理结果
        System.out.println(result);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
