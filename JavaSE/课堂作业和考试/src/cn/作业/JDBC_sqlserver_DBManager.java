package cn.作业;

import com.mysql.cj.x.protobuf.MysqlxSession;

import java.sql.*;

/*
1.利用JDBC实现对数据库的增删改查。
2.创建DBManager类， 封装增删改方法，通过调用来实现数据库的操作。

create database Student
go
--打开数据库
use Student
go
--创建数据表.
create table StuInfo
(
ID int primary key identity(1001,1),--学号
Name varchar(10) not null,			--姓名
Gender varchar(2) default '男',	    --性别默认为男
Age int default 19,					--年龄默认为19
TelPhone varchar(11),				--手机号
QQ varchar(30) unique				--qq号
)
GO
--添加测试记录
insert StuInfo values('汪满青','男',20,'15972818392',1537957527)
insert StuInfo values('张三','男',18,'13135624963',123456)
insert StuInfo values('李四','男',19,'13135624964',50637694)
insert StuInfo values('王五','男',19,'13135624965',7878112)
insert StuInfo values('赵六','女',18,'13135624966',133456)
insert StuInfo values('李斯','女',19,'13135624967',456668)
go
--查询
select * from StuInfo
********************************************
以上述数据库为基础，利用JDBC数据访问技术,编写代码实现对StuInfo (学生信息表) 的增删改查。具体要求如下:
1、以学号(ID)作为查询的条件,内容自定义;
2、以学号作为删除和更新的条件，内容自定义;
3、以自己的信息为数据,添加一条记录。

 */
public class JDBC_sqlserver_DBManager {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=Student";
    static String user = "sa";
    static String pwd = "123";

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    //获取连接
    public static Connection getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void Close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    //查询全部
    public static void Query() throws SQLException {
        try {
            conn = getConn();
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

    public static void main(String[] args) throws SQLException {
        Query();
    }

}
