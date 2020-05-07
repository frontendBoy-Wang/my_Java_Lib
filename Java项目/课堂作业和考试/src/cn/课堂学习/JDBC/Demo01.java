package cn.课堂学习.JDBC;

import java.sql.*;

public class Demo01 {
    static String driver = "com . microsoft. sqlserver . jdbc . SQLServerDriver";//声明驱动字符串
    static String urL = "jdbc : sqlserver://localhost :1433; DataBaseName=Xk";//声明连接字符串
    static String user="sa";
    static  String password="123";
    static Connection conn = null;//声明连接对象
    static PreparedStatement pst=null;//声明预编译声明对象
    static Statement sta = null;//声明结果集对象
    static ResultSet rs = null;//声明结果对象

    public static void main(String[] args) throws SQLException {
        try {
            //驱动加载
            Class.forName(driver);
            //创建连接
            conn=DriverManager.getConnection(urL,user,password);
            //声明命令字符串
            String sql="insert user value (?,?)";
            //创建预编译声明对象
            pst=conn.prepareStatement(sql);
            //参数与占位符进行关联
            pst.setObject(1,"wmq");
            pst.setObject(1,"123456");
            //预编译声明对象调用执行方法
            pst.execute();
            //重写声明命令字符串
            sql="select * from m_user";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //遍历结果集
            while (rs.next()){
                System.out.println(rs.getObject(sql));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
