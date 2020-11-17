package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */
public class JDBC_Pool_Utils {
    //定义成员变量DateSource
    private static DataSource ds;

    static {

        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement stm, Connection conn) {
       /* if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();//向数据库连接池归还连接对象
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        close(null, stm, conn);
    }

    public static void close(ResultSet rs, Statement stm, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();//向数据库连接池归还连接对象
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池
     */

    public static  DataSource getDs(){
        return ds;
    }
}

//============================================
/**
 * 使用新的工具类
 */
class Demo02Druid{
    public static void main(String[] args) {
        /**
         * 完成添加的操作,给account表添加一条记录
         */
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            //1.获取连接
             conn = JDBC_Pool_Utils.getConnection();
            //2.定义SQL语句
            String sql="insert into account values (null ,?,?);";
            //3.获取执行SQL的对象PreparedStatement
             pstm = conn.prepareStatement(sql);
            //4.给?赋值
            pstm.setObject(1,"赵琴");
            pstm.setObject(2,3000);
            //5.执行SQL
            int count = pstm.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBC_Pool_Utils.close(pstm,conn);
        }

    }
}






















