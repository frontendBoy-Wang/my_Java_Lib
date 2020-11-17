package spring_jdbc.demo;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import util.JDBC_Pool_Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 Spring JDBC
 * Spring框架对JDBC的简单封装。提供了-个JDBCTemplate对象简化JDBC的开发
 *步骤:
 1.导入jar包
 2.创建JdbcTemplate对象。 依赖于数据源DataSource
 * JdbcTemplate template = new JdbcTemplate(ds);
 3.调用JdbcTemplate的方法来完成CRUD的操作
 * update():执行DML语句。增、删、改语句
 queryForMap():查询结果将结果集封装为map集合,将列名作为key,将值作为value将这条记录封装为-个map集合
 *注意:这个方法查询的结果集长度只能是1
 * queryForList(): 查询结果将结果集封装为list集合
 注意:将每一条记录封装为一个Map集合,再將Map集合装载到List集合中
 * query():查询结果,将结果封装为JavaBean对象
 * query的参数: RowMapper
 * 一般我们使用BeanPropertyRowMapper实现类。 可以完成数据到JavaBean的自动封装
 * new BeanPropertyRowMapper<类型>(类型.class)
 * queryForObject :查询结果,将结果封装为对象
 *一般用于聚合函数的查询
 */

/**
 * 4.练习:
 * 需求:
 * 1.修改1号数据的salary 为10000
 * 2.添加一条记录
 * 3.删除刚才添加的记录
 * 4.查询id为1的记录,将其封装为Map集合
 * 5.查询所有记录，将其封装为list
 * 6.查询所有记录,将其封装为Emp对象的list集合
 * 7.查询总记录数
 */
public class Demo02JdbcTemplate {
    //Junit单元测试,可以让方法独立执行
    //获取连接对象
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBC_Pool_Utils.getDs());

    /**
     * 1.修改1号的数据为salary为19999
     */
    @Test
    public void test1() {

        //定义SQL
        String sql = "update emp set salary=19999 where id=1001";
        //执行SQL
        int count = jdbcTemplate.update(sql);
        System.out.println(count + ":修改成功");
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void test2() {
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = jdbcTemplate.update(sql, 1015, "汪满青", 10);
        System.out.println(count);
    }

    /**
     * 3删除刚刚添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id=?";
        int count = jdbcTemplate.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 4查询id为1的记录,将其封装为Map集合
     * 查询的结果集只能是1
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id=? or id=?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1001, 1002);
        System.out.println(map);
        //{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=19999.00, bonus=null, dept_id=20}
    }

    /**
     * 5查询所有的记录,将其封装为list集合
     */
    @Test
    public void test5() {
        String sql = "select * from emp ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> k : list) {
            System.out.println(k);
        }

    }

    /**
     * 6.查询所有记录,将其封装为Emp对象的list集合
     */
    @Test
    public void test6() {
        String sql = "select * from emp ";
        List<Emp> list = jdbcTemplate.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
        for (Emp k : list) {
            System.out.println(k);
        }
    }

    @Test
    public void test6_2() {
        String sql = "select * from emp ";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }

    }

    /**
     * 7.查询总的记录数
     */
    @Test
    public void test7() {
        String sql = "select count(id) from emp ";
        Long total = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(total);

    }
}
