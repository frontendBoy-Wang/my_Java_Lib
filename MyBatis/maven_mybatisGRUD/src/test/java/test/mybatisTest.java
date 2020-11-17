package test;

import dao.IUserDao;
import domain.QueryVo;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:mybatisTest
 * @Description:测试mybatis的方法
 * @Author: 汪满青
 * @Date: 2020-06-21 16:55
 */
public class mybatisTest {
    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;

    /***
     * @Title: init()
     * @Author: 汪满青
     * @Description: 初始化操作
     * @Date: 2020/6/21-18:05
     * @Param: []
     * @return: void
     **/
    @Before//在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输出流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.h获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
        
    }

    /***
     * @Title: destory()
     * @Author: 汪满青
     * @Description: 释放资源
     * @Date: 2020/6/21-18:06
     * @Param: []
     * @return: void
     **/
    @After//在测试执行之后执行
    public void destory() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        is.close();
    }


    /***
     * @Title: testFindAll()
     * @Author: 汪满青
     * @Description: 查询所有
     * @Date: 2020/6/21-18:04
     * @Param: []
     * @return: void
     **/
    @Test
    public void testFindAll() {
        //5.执行 查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /***
     * @Title: testSave()
     * @Author: 汪满青
     * @Description: 保存用户
     * @Date: 2020/6/21-18:05
     * @Param: []
     * @return: void
     **/
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis last insertid");
        user.setAddress("湖北黄冈");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作前：" + user);
        //5执行保存方法
        userDao.saveUser(user);

        System.out.println("保存操作后：" + user);
    }

    /**
     * @Title: testUpdate()
     * @Author: 汪满青
     * @Description: 更新
     * @Date: 2020/6/21-18:48
     * @Param: []
     * @return: void
     **/
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("赵琴");
        user.setAddress("湖北黄冈");
        user.setSex("女");
        user.setBirthday(new Date());

        //5执行更新方法
        userDao.updateUser(user);
    }

    /**
     * @Title: testDelete()
     * @Author: 汪满青
     * @Description: 删除方法
     * @Date: 2020/6/21-18:47
     * @Param: []
     * @return: void
     **/
    @Test
    public void testDelete() {
        //5执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * @Title: testFindById()
     * @Author: 汪满青
     * @Description: 根据ID查询用户信息
     * @Date: 2020/6/21-18:57
     * @Param: []
     * @return: void
     **/
    @Test
    public void testFindById() {
        //5执行根据ID查询用户信息
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * @Title:testFindByUserName()
     * @Author: 汪满青
     * @Description: 根据用户名称模糊查询
     * @Date: 2020/6/21-19:08
     * @Param: []
     * @return: void
     **/
    @Test
    public void testFindByUserName() {
        //5执行根据用户名称模糊查询方法
        //List<User> users = userDao.findUserName("%王%");
        List<User> users = userDao.findUserName("赵琴");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * @Title:
     * @Author: 汪满青
     * @Description: 查询总记录
     * @Date: 2020/7/2-17:16
     * @Param: []
     * @return: void
     **/
    @Test
    public void testFindTotal() {
        //执行一个查询方法
        int conut = userDao.findTotal();
        System.out.println(conut);
    }

    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        vo.setUser(user);
        user.setUsername("%王%");
        //5执行一个查询方法
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * @Title:
     * @Author: 汪满青
     * @Description: 查询所有
     * @Date: 2020/7/10-10:53
     * @Param: []
     * @return: void
     **/
    @Test
    public void testFindUserByCondition() {
        User u = new User();
        u.setUsername("老王");

        //5.执行查询所有方法
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }


}
