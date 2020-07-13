package com.bjsxt.service;

import java.util.Map;

import com.bjsxt.common.Result;
import com.bjsxt.pojo.Users;

/**
 * @ClassName: IUsersService 
 * @Description: 用户业务接口
 * @author: Mr.T
 * @date: 2020年6月28日 下午4:47:14
 */
public interface IUsersService {
	
	/**
	 * @Title: login
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午4:47:53 
	 * @Description: 登录方法
	 * @param username  用户名
	 * @param password  密码
	 * @return
	 * @return: Result
	 */
	Result login(String username,String password);
	
	/**
	 * @Title: queryPage
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午6:10:01 
	 * @Description: 分页查询数据
	 * @param param 参数
	 * @return 
	 * @return: Result
	 */
	Result queryPage(Map<String, Object> param);
	/**
	 * @Title: resetPassword
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午2:44:31 
	 * @Description: 根据ID 重置密码
	 * @param id
	 * @return
	 * @return: Result
	 */
	Result resetPassword(int id);
	/**
	 * @Title: quit
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午2:55:57 
	 * @Description: 员工离职
	 * @param parseInt
	 * @return
	 * @return: Result
	 */
	Result quit(int parseInt);
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午4:00:31 
	 * @Description: 新增用户方法
	 * @param user
	 * @return
	 * @return: Result
	 */
	Result add(Users user);
	/**
	 * @Title: updatePassoword
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午5:03:24 
	 * @Description: 根据id修改密码
	 * @param id
	 * @param confimPassword
	 * @return
	 * @return: Result
	 */
	Result updatePassoword(Integer id, String confimPassword);
	/**
	 * @Title: querySalesman
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午3:53:24 
	 * @Description: 查询所有的业务员
	 * @return
	 * @return: Result
	 */
	Result querySalesman();
	/**
	 * @Title: updateUserImg
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午4:50:20 
	 * @Description: 根据ID 修改用户头像
	 * @param id
	 * @param url
	 * @return
	 * @return: Result
	 */
	Result updateUserImg(Integer id, String url);

}
