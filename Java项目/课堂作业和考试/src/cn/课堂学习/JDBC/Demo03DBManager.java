package cn.课堂学习.JDBC;

import java.sql.*;

public class Demo03DBManager {

    //声明驱动字符串
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //声明连接字符串
    public static String url="jdbc:sqlserver://localhost:1433;DataBaseName=Xk";
    //声明连接对象
    public static Connection conn=null;
    //声明预编译声明对象
    public static PreparedStatement pst=null;
    //声明结果集对象
    public static ResultSet rs=null;

    //获取连接对象
    public static Connection getConn(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, "sa", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //无条件查询：输出所有学生的信息
    public static ResultSet runSelect(String sql){
        try {
            conn=getConn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    //有条件查询，输出指定条件的学生信息
    public static ResultSet runSelect(String sql,Object[] params){
        try {
            conn=getConn();
            pst=conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1, params[i]);
            }
            rs=pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    //增删改
    public static boolean runUpdate(String sql,Object[] params) throws SQLException{
        try {
            conn=getConn();
            pst=conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1, params[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pst.execute();
    }

    //关闭预编译声明对象
    public static void closePst(){
        try {
            if(pst!=null){
                pst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭连接对象
    public static void closeConn(){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*


//导入包
import java.sql.*;

public class DBManager {

	//声明驱动字符串
	public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//声明连接字符串
	public static String url="jdbc:sqlserver://localhost:1433;DataBaseName=student";
	//声明连接对象
	public static Connection conn=null;
	//声明预编译声明对象
	public static PreparedStatement pst=null;
	//声明结果集对象
	public static ResultSet rs=null;

	//获取连接对象
	public static Connection getConn(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, "sa", "sa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	//无条件查询：输出所有学生的信息
	public static ResultSet runSelect(String sql){
		try {
			conn=getConn();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	//有条件查询，输出指定条件的学生信息
	public static ResultSet runSelect(String sql,Object[] params){
		try {
			conn=getConn();
			pst=conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
			rs=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	//增删改
	public static boolean runUpdate(String sql,Object[] params) throws SQLException{
		try {
			conn=getConn();
			pst=conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pst.execute();
	}

	//关闭预编译声明对象
	public static void closePst(){
		try {
			if(pst!=null){
				pst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//关闭连接对象
	public static void closeConn(){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

*/
