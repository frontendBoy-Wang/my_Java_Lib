package com.bjsxt.dao;

import java.util.Date;
import java.util.Map;

import com.bjsxt.common.Constant;
import com.bjsxt.common.PageInfo;
import com.bjsxt.pojo.Customer;

import cn.hutool.core.date.DateUtil;

public class CustomerDao extends BaseDao {
	/**
	 * 
	 * @Title: selectPage
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午2:26:49 
	 * @Description: 分页查询客户信息
	 * @param param  搜索的参数
	 * 		客户名 		custName   
	 * 		客户公司  	company    
	 * 		职位  		position   
	 * 		工资范围        	最低工资 minSalary  最高工资 maxSalary
	 * 		电话 		phone	
	 * 		性别  		sex
	 * 		状态  		state
	 * 		业务员 		userId
	 * 		创建时间          minCreateTime  maxCreateTime
	 * @return
	 * @return: PageInfo<Customer>
	 */
	public PageInfo<Customer> selectPage(Map<String, Object> param) {
		Integer page = Integer.parseInt(param.get("page").toString());
		Integer limit = Integer.parseInt(param.get("limit").toString());
		//sql 动态拼接
		String sql = "select c.id, c.cust_name as custName, c.company, c.position, c.salary, c.phone, c.sex, c.state, c.user_id as userId,u.real_name as realName , c.create_time as createTime, c.modify_time as modifyTime from customer c left join `users` u on c.user_id = u.id where 1=1	";
		//客户名称
		if(param.containsKey("custName")) {
			sql = sql + " and c.cust_name like '%"+param.get("custName")+"%' ";
		}
		//客户公司
		if(param.containsKey("company")) {
			sql = sql + " and c.company like '%"+param.get("company")+"%' ";
		}
		//客户职位
		if(param.containsKey("position")) {
			sql = sql + " and c.position like '%"+param.get("position")+"%' ";
		}
		//工资范围
		if(param.containsKey("minSalary")) {
			sql = sql + " and c.salary >="+param.get("minSalary")+"  ";
		}
		if(param.containsKey("maxSalary")) {
			sql = sql + " and c.salary <="+param.get("maxSalary")+"  ";
		}
		//电话
		if(param.containsKey("phone")) {
			sql = sql + " and c.phone ='"+param.get("phone")+"'  ";
		}
		//性别
		if(param.containsKey("sex")) {
			sql = sql + " and c.sex ="+param.get("sex")+"  ";
		}
		//状态
		if(param.containsKey("state")) {
			sql = sql + " and c.state ="+param.get("state")+"  ";
		}
		//业务员
		if(param.containsKey("userId")) {
			sql = sql + " and c.user_id ="+param.get("userId")+"  ";
		}
		//创建时间
		if(param.containsKey("minCreateTime")) {
			sql = sql + " and c.create_time >='"+param.get("minCreateTime")+" 00:00:00'  ";
		}
		if(param.containsKey("maxCreateTime")) {
			sql = sql + " and c.create_time <='"+param.get("maxCreateTime")+" 23:59:59'  ";
		}
		sql = sql + " order by c.create_time desc  ";
		System.out.println("分页的sql为： "+ sql);
		return super.selectPage(sql, Customer.class, page, limit);
	}
	/**
	 * @Title: selectObjByPhone
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午4:41:54 
	 * @Description: 根据手机号查询客户
	 * @param phone
	 * @return
	 * @return: Customer
	 */
	public Customer selectObjByPhone(String phone) {
		String sql = "select id from customer where phone = ?";
		return super.selectObj(sql, Customer.class, phone);
	}
	/**
	 * @Title: insert
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午4:48:29 
	 * @Description: 新增客户
	 * @param customer
	 * @return: void
	 */
	public void insert(Customer customer) {
		String sql = "INSERT INTO `customer`( `cust_name`, `company`, `position`, `salary`, `phone`, `sex`, `state`, `user_id`, `create_time`, `modify_time`) VALUES (?, ?,?,?, ?, ?, ?, ?,?,?)";
		super.update(sql, customer.getCustName(),customer.getCompany(),customer.getPosition(),customer.getSalary(),customer.getPhone(),customer.getSex(),customer.getState(),customer.getUserId(),customer.getCreateTime(),customer.getModifyTime());
	}
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午5:24:20 
	 * @Description: 根据ID 修改客户信息
	 * @param customer
	 * @return: void
	 */
	public void update(Customer customer) {
		String sql = "update customer set cust_name = ?,company = ?,position = ?,salary = ?,phone = ?,sex = ?,state = ?,modify_time = ? where id = ?";
		super.update(sql, customer.getCustName(),customer.getCompany(),customer.getPosition(),customer.getSalary(),customer.getPhone(),customer.getSex(),customer.getState(),customer.getModifyTime(),customer.getId());
	}
	/**
	 * @Title: batchDelete
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午5:35:50 
	 * @Description: 批量删除
	 * @param id
	 * @return: void
	 */
	public void batchDelete(String[] id) {
		String ids = "";
		for (int i = 0; i < id.length; i++) {
			ids = ids + id[i]+",";//1,2,3,
		}
		ids = ids.substring(0,ids.length() - 1);
		String sql = "update customer set state = 2 where id in ("+ids+")";
		super.update(sql);
	}
	/**
	 * @Title: batchUpdateUserId
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午2:27:32 
	 * @Description: 批量修改业务员ID
	 * @param userId
	 * @param id
	 * @return: void
	 */
	public void batchUpdateUserId(String userId, String[] id) {
		String ids = "";
		for (int i = 0; i < id.length; i++) {
			ids = ids + id[i]+",";//1,2,3,
		}
		ids = ids.substring(0,ids.length() - 1);
		String sql = "update customer set user_id = ?,modify_time=? where id in ("+ids+")";
		System.out.println(sql);
		super.update(sql,userId,DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
	}
}
