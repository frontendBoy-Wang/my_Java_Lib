package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account 表 添加一条记录inset语句
 */
public class Demo02ExecuteUpdate增 {
    static Statement stm = null;
    static Connection conn = null;

    public static void main(String[] args) {
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义SQL
            String sql = "insert into account values(null,'汪满青',3000)";
            //3.获取Connection对象
            Connection conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "wmq12138");
            //4.获取执行SQL的对象Statement
            Statement stm = conn.createStatement();
            //5.执行sql
            int count = stm.executeUpdate(sql);
            //6.处理结果
            System.out.println("count = " + count);
            if (count > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm!=null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
