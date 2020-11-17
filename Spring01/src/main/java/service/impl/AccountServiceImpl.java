package service.impl;

import dao.IAccountDao;
import factory.BeanFactory;
import service.IAccountService;

/**
 * @ClassName:AccountServiceImpl
 * @Description: 账户的业务层实现类
 * @Author: 汪满青
 * @Date: 2020-07-14 13:26
 */
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    //private int i = 1;

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
