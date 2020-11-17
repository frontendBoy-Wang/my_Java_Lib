package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class Demo05ExecuteUpdateDDL {
    public static void main(String[] args) {
        Statement stm=null;
        Connection conn=null;
        try {//1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "wmq12138");
            //3.定义SQL语句
            String sql="create table studentDB (id int,name varchar(20))";
            //4.获取执行SQL语句的对象Statement
            stm = conn.createStatement();
            //5.执行SQL语句
            int count = stm.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            /*if (count>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
