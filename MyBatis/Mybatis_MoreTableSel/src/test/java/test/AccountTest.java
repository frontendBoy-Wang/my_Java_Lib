package test;

import dao.IAccountDao;
import domain.Account;
import domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName:AccountTest
 * @Description:
 * @Author: 汪满青
 * @Date: 2020-07-10 17:19
 */
public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

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
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.h获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
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
        in.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAllAccountUser() {
        List<AccountUser> aus = accountDao.findAllAccount();
        for (Account account : aus) {
            System.out.println(account);
        }
    }
}
