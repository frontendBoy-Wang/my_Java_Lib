package com.bjsxt.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName: JdbcUtil 
 * @Description: Jdbc工具类
 * @author: Mr.T
 * @date: 2020年6月11日 下午5:38:21
 */
public class JdbcUtil {
	
	//数据库url
	private static String url;
	//登录用户名
	private static String user;
	//登录密码
	private static String password;
	//使用静态代码块 初始化数据
	static{
		//读取配置文件
		try {
			//使用类加载器 JVM的类加载器 ： 3个 
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.propertis");
			//转化为配置文件
			Properties prop = new Properties();
			//将文件中的数据进行读取
			prop.load(in);
			//从配置对象中获取配置文件中数据
			url = prop.getProperty("jdbc.url");
			user = prop.getProperty("jdbc.user");
			password = prop.getProperty("jdbc.password");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: getConnection
	 * @author: Mr.T   
	 * @date: 2020年6月11日 下午5:42:20 
	 * @Description: 获取数据库连接对象
	 * @return
	 * @return: Connection
	 */
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @Title: getPrep
	 * @author: Mr.T   
	 * @date: 2020年6月11日 下午5:43:45 
	 * @Description: 获取指令对象方法
	 * @param sql
	 * @return
	 * @return: PreparedStatement
	 */
	public static PreparedStatement getPrep(String sql) {
		try {
			PreparedStatement prep = getConnection().prepareStatement(sql);
			return prep;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn,PreparedStatement prep) {
		try {
			prep.close();
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn,PreparedStatement prep,ResultSet rs) {
		try {
			rs.close();
			close(conn,prep);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
