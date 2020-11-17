package cn.课堂学习.JDBC;

import java.sql.*;

public class InsertDemo05添加 {
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
        //插入
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
            //获取用户输入的数据
            int StuNo=1001;
            int ClassNo=1101;
            String sql="insert Student values(?,?)";
            pst=conn.prepareStatement(sql);
            pst.setObject(1,StuNo);
            pst.setObject(2,ClassNo);
            //执行
            pst.execute();
            //
            sql="select * from Student";
            //
            //
            ResultSet resultSet = pst.executeQuery(sql);

            System.out.println("学号\t\t班级号\t\t姓名\t密码");
            while (rst.next()) {

                System.out.println(rst.getObject("StuNo")
                        + "\t" + rst.getObject("ClassNo")
                        + "\t" + rst.getObject("StuName")
                        + "\t" + rst.getObject("Pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (conn!=null) {
                conn.close();
            }
            if (pst!=null) {
                pst.close();
            }
            if (rst!=null) {
                rst.close();
            }
        }
    }
}
