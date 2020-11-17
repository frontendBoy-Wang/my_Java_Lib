package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo10事务 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        try {
            //获取连接
            conn = JDBCUtils.getConn();
            conn.setAutoCommit(false);//开启事物
            //定义SQL语句
            String sql1 = "update account set balance=balance-? where id=?;";//zhangsan-100
            String sql2 = "update account set balance=balance+? where id=?;";//zhangsan-100
            //获取执行SQL对象
            pstm1 = conn.prepareStatement(sql1);
            pstm2 = conn.prepareStatement(sql2);
            //设置参数
            pstm1.setDouble(1, 500);
            pstm1.setInt(2, 1);

            pstm2.setDouble(1, 500);
            pstm2.setInt(2, 2);
            //执行sql
            pstm1.executeUpdate();
            //手动异常
            int i = 3 / 0;
            pstm2.executeUpdate();
            conn.commit();//提交事物
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            /*if (pstm1!=null){
                try {
                    pstm1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (pstm2!=null){
                try {
                    pstm2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
            JDBCUtils.close(null, pstm1, conn);
            JDBCUtils.close(null, pstm2, null);
        }
    }

}
