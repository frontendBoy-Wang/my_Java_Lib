package jdbc;

import java.sql.*;

/**
 * @ClassName:jdbcDemo01
 * @Description: 程序的耦合：程序的依赖关系(类之间的依赖关系和方法之间的依赖关系)。
 *                    解耦：降低程序之间的依赖关系
 * @Author: 汪满青
 * @Date: 2020-07-14 12:51
 */
public class jdbcDemo01 {
    public static void main(String[] args) throws SQLException {
        try {
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //2.获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql:///springdb", "root", "wmq12138");
            //3.获取操纵数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select * from springdb.account");
            //4.执行sql，的到结果集
            ResultSet rs = pstm.executeQuery();
            //5.遍历结果集
            System.out.println("ID\t" + "姓名\t" + "工资");
            while (rs.next()) {
                System.out.print(rs.getObject("id") + "\t");
                System.out.print(rs.getString("name") + "\t");
                System.out.print(rs.getString("money") + "\n");
            }
            //6.释放资源
            rs.close();
            pstm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
