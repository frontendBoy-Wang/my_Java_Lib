package test;

import dao.UserDao;
import domain.User;


public class UserDaoTest {



    @org.junit.Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("wmq");
        loginuser.setPassword("123");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
