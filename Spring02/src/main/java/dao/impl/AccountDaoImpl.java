package dao.impl;

import dao.IAccountDao;

/**
 * @ClassName:AccountDaoImpl
 * @Description: 账户的持久层实现类
 * @Author: 汪满青
 * @Date: 2020-07-14 13:31
 */
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
