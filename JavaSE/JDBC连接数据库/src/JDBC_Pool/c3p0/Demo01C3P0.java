package JDBC_Pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 */
public class Demo01C3P0 {
    public static void main(String[] args) throws SQLException {
        /*//1.获取DataSource,使用默认配置
        DataSource ds = new ComboPooledDataSource();

        //2.获取连接对象
        //打印
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

            if (i == 5) {
                conn.close();//归还连接到数据库中
            }
        }*/
        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        // 1.1获取DataSource,使用指定名称配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        //2.获取连接对象
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
        }
    }

}
