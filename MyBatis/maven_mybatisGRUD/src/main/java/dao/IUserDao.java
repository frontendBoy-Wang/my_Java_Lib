package dao;

import domain.QueryVo;
import domain.User;

import java.util.List;

/**
 * @ClassName:IUserDao
 * @Author: 汪满青
 * @Description: 用户的持久层接口
 * @Date: 2020/6/21-18:36
 **/
public interface IUserDao {
    /**
     * @Title: findAll()
     * @Author: 汪满青
     * @Description: 查询所有
     * @Date: 2020/6/21-18:16
     * @Param: []
     * @return: java.util.List<domain.User>
     **/
    List<User> findAll();

    /**
     * @Title: saveUser()
     * @Author: 汪满青
     * @Description: 保存用户
     * @Date: 2020/6/21-18:17
     * @Param: [user]
     * @return: void
     **/
    void saveUser(User user);

    /**
     * @Title: updateUser()
     * @Author: 汪满青
     * @Description: 更新用户
     * @Date: 2020/6/21-18:18
     * @Param: [user]
     * @return: void
     **/
    void updateUser(User user);

    /**
     * @Title: deleteUser()
     * @Author: 汪满青
     * @Description: 根据ID删除用户
     * @Date: 2020/6/21-18:40
     * @Param: [userId]
     * @return: void
     **/
    void deleteUser(Integer userId);

    /**
     * @Title: findByID()
     * @Author: 汪满青
     * @Description: 根据ID查询用户信息
     * @Date: 2020/6/21-18:49
     * @Param: [userId]
     * @return: void
     **/
    User findById(Integer userId);

    /**
     * @Title: findUserName()
     * @Author: 汪满青
     * @Description: 根据用户名称模糊查询
     * @Date: 2020/6/21-19:03
     * @Param: [username]
     * @return: java.util.List<domain.User>
     **/
    List<User> findUserName(String username);

    /**
     * @Title:
     * @Author: 汪满青
     * @Description: 查询总的用户数
     * @Date: 2020/7/2-17:12
     * @Param: []
     * @return: int
     **/
    int findTotal();

    /***
     * @Title:
     * @Author: 汪满青
     * @Description: 根据queryVo中的条件查询
     * @Date: 2020/7/6-22:39
     * @Param: [vo]
     * @return: int
     **/
    List<User> findUserByVo(QueryVo vo);

    /**
     * @Title: findUserByCcndition
     * @Author: 汪满青
     * @Description: 根据传入参数条件查询
     * @Date: 2020/7/10-10:41
     * @Param: [user] 查询的条件：有可能是用户名，有可能是性别 ，地址
     * @return: java.util.List<domain.User>
     **/
    List<User> findUserByCondition(User user);
}
