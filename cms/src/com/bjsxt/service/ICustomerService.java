package com.bjsxt.service;

import java.util.Map;

import com.bjsxt.common.Result;
import com.bjsxt.pojo.Customer;

/**
 * @ClassName: ICustomer 
 * @Description: 客户业务类
 * @author: Mr.T
 * @date: 2020年6月30日 下午2:36:17
 */
public interface ICustomerService {
	/**
	 * @Title: queryPage
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午2:36:43 
	 * @Description: 分页查询客户
	 * @param param
	 * @return
	 * @return: Result
	 */
	Result queryPage(Map<String, Object> param);
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午4:39:06 
	 * @Description: 新增客户
	 * @param customer
	 * @return
	 * @return: Result
	 */
	Result add(Customer customer);
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午5:19:29 
	 * @Description: 修改客户信息
	 * @param customer
	 * @return
	 * @return: Result
	 */
	Result update(Customer customer);
	/**
	 * @Title: batchDelete
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午5:34:52 
	 * @Description: 根据ID  删除客户
	 * @param id
	 * @return
	 * @return: Result
	 */
	Result batchDelete(String[] id);
	/**
	 * @Title: updateUserId
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午2:26:40 
	 * @Description: 修改客户业务员ID
	 * @param userId   业务员ID
	 * @param id		客户ID
	 * @return
	 * @return: Result
	 */
	Result updateUserId(String userId, String[] id);

}
