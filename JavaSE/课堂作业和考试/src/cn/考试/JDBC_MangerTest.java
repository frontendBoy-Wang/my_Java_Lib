package cn.考试;

import java.sql.*;
import java.util.Scanner;

/**
 * @author WMQ
 */
public class JDBC_MangerTest {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=Student";
    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    //获取连接
    public static Connection getconn() {
        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, "sa", "123");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void Close(ResultSet rst, PreparedStatement pst, Connection conn) throws SQLException {
        if (rst != null) {
            rst.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public void Query() throws SQLException {
        System.out.print("请输入要查询的ID:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        try {
            conn = getconn();
            String sql = "select * from StuInfo where ID='" + id + "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject("ID") + "\t" + rs.getObject("Name") + "\t" + rs.getObject("Gender")
                        + "\t" + rs.getObject("Age") + "\t" + rs.getObject("Telphone") + "\t" + rs.getObject("QQ"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            scanner.close();
            Close(rs, ps, conn);
        }
    }

    //查询全部
    public void QueryAll() throws SQLException {
        try {
            conn = getconn();
            String sql = "select * from StuInfo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject("ID")
                        + "\t" + rs.getObject("Name")
                        + "\t\t" + rs.getObject("Gender")
                        + "\t\t" + rs.getObject("Age")
                        + "\t\t" + rs.getObject("Telphone")
                        + "\t" + rs.getObject("QQ"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Close(rs, ps, conn);
        }

    }

    public void Delete() throws SQLException {
        System.out.println("请输入要删除的ID:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        try {
            conn = getconn();
            String sql = "delete from StuInfo where ID='" + id + "'";
            ps = conn.prepareStatement(sql);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("删除成功!");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            scanner.close();
            Close(rs, ps, conn);
        }
    }

    public void Update() throws SQLException {
        System.out.println("请输入ID:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("请输入新的姓名");
        String name = scanner.next();
        System.out.println("请输入新的年龄");
        int age = scanner.nextInt();
        System.out.println("请输入新的电话");
        String tel = scanner.next();
        System.out.println("请输入新的QQ");
        String qq = scanner.next();
        try {
            conn = getconn();
            String sql = "update StuInfo set Name='" + name + "',Age=" + age + ",Telphone='" + tel + "',QQ='" + qq + "' where ID='" + id + "'";
            ps = conn.prepareStatement(sql);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("更新成功");
            }
            String sql1 = "select *from StuInfo where ID='" + id + "'";
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject("ID") + "\t" + rs.getObject("Name") + "\t" + rs.getObject("Gender")
                        + "\t" + rs.getObject("Age") + "\t" + rs.getObject("Telphone") + "\t" + rs.getObject("QQ"));
            }
            System.out.println("成功");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            scanner.close();
            Close(rs, ps, conn);
        }
    }

    public void Insert() throws SQLException {
        try {
            conn = getconn();
            String sql = "Insert StuInfo values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "汪满青");
            ps.setObject(2, "男");
            ps.setObject(3, 21);
            ps.setObject(4, "1234567899");
            ps.setObject(5, "987654321");
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("添加成功");
            }
            String sql1 = "select *from StuInfo";
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject("ID") + "\t" + rs.getObject("Name") + "\t" + rs.getObject("Gender")
                        + "\t" + rs.getObject("Age") + "\t" + rs.getObject("Telphone") + "\t" + rs.getObject("QQ"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            Close(rs, ps, conn);
        }
    }

    public static void main(String[] args) throws SQLException {
        JDBC_MangerTest JDBC_MangerTest = new JDBC_MangerTest();
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
        System.out.println("♥\t\t0.查询所有\t♥");
        System.out.println("♥\t\t1.查询\t\t♥");
        System.out.println("♥\t\t2.删除\t\t♥");
        System.out.println("♥\t\t3.更新\t\t♥");
        System.out.println("♥\t\t4.添加\t\t♥");
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

        System.out.print("请选择您要进行的操作:");
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        if (i == 0) {
            JDBC_MangerTest.QueryAll();
        } else if (i == 1) {
            JDBC_MangerTest.Query();
        } else if (i == 2) {
            JDBC_MangerTest.Delete();
        } else if (i == 3) {
            JDBC_MangerTest.Update();
        } else if (i == 4) {
            JDBC_MangerTest.Insert();
        } else {
            System.out.println("选择了无效项");
        }
        scanner.close();


    }
}