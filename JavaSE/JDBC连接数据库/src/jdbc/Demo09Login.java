package jdbc;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习
 * 需求:
 * 1.通过键盘输入用户名和密码
 * 2.判断用户是否登陆成功
 */
public class Demo09Login {
    public static void main(String[] args) {
        //1.通过键盘输入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名:");
        String username = sc.nextLine();
        System.out.println("输入密码:");
        String password = sc.nextLine();
        //2.调用方法
        boolean flag = new Demo09Login().login(username, password);
        //3.判断结果,输出不同的语句
        if (flag) {
            System.out.println("登陆成功");
        } else {
            System.out.println("用户名或者密码错误");
        }
    }

    /**
     * 登陆方法
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库判断是否登陆成功

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            //1.获取连接
            conn = JDBCUtils.getConn();
            //2.定义SQL语句
            String sql = "select * from user where username=? and password=?";
            //3.获取执行SQL的对象
            pstm = conn.prepareStatement(sql);
            //给?赋值
            pstm.setString(1,username);
            pstm.setString(2,password);
            //4.执行 SQL ,不需要传递sql
            rs = pstm.executeQuery();
            //5.判断
           /* if (rs.next()){
                return true;
            }else {
                return false;
            }*/
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstm, conn);
        }
        return false;
    }
}
