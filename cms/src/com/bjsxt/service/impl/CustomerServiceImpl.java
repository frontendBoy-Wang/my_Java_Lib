package com.bjsxt.service.impl;

import java.util.Date;
import java.util.Map;

import com.bjsxt.common.CodeMsg;
import com.bjsxt.common.Constant;
import com.bjsxt.common.PageInfo;
import com.bjsxt.common.Result;
import com.bjsxt.dao.CustomerDao;
import com.bjsxt.pojo.Customer;
import com.bjsxt.service.ICustomerService;

import cn.hutool.core.date.DateUtil;

public class CustomerServiceImpl implements ICustomerService {
	
	private CustomerDao customerDao = new CustomerDao();

	@Override
	public Result queryPage(Map<String, Object> param) {
		PageInfo<Customer> pageInfo = customerDao.selectPage(param);
		return new Result(pageInfo);
	}

	@Override
	public Result add(Customer customer) {
		//进行数据校验
		//手机号 是否存在
		Customer c = customerDao.selectObjByPhone(customer.getPhone());
		if(c != null) {
			return new Result(CodeMsg.CUSTOMER_PHONE_EXIST_ERROR);
		}
		customer.setCreateTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		customer.setModifyTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		customerDao.insert(customer);
		return new Result();
	}

	@Override
	public Result update(Customer customer) {
		//进行数据校验
		//手机号 是否存在
		Customer c = customerDao.selectObjByPhone(customer.getPhone());
		if(c != null && !c.getId().equals(customer.getId())) {
			return new Result(CodeMsg.CUSTOMER_PHONE_EXIST_ERROR);
		}
		customer.setModifyTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		customerDao.update(customer);
		return new Result();
	}

	@Override
	public Result batchDelete(String[] id) {
		customerDao.batchDelete(id);
		return new Result();
		
	}

	@Override
	public Result updateUserId(String userId, String[] id) {
		customerDao.batchUpdateUserId(userId,id);
		return new Result();
	}

}
