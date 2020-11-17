package jdbc;

import java.sql.*;

public class Demo06executeQuery查询 {
    public static void main(String[] args) {
        Statement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        try {//1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "wmq12138");
            //3.定义SQL语句
            String sql = "select * from account;";
            //4.获取执行SQL语句的对象Statement
            stm = conn.createStatement();
            //5.执行SQL语句
            rs = stm.executeQuery(sql);
            //6.处理结果
            //6.1让游标向下一行移动
            //6.2获取数据
            while (rs.next()){
                //获取数据
                //
                Object id = rs.getObject(1);
                Object name = rs.getObject("name");
                Object balance = rs.getObject(3);
                System.out.println(id+"====>"+name+"====>"+balance);
            }
            /* rs.next();
            Object id = rs.getObject(1);
            Object name = rs.getObject("name");
            Object balance = rs.getObject(3);
            System.out.println(id+"====>"+name+"====>"+balance);*/
            /*if (count>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
