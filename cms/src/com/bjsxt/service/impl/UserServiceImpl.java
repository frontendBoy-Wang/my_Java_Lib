package com.bjsxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bjsxt.common.CodeMsg;
import com.bjsxt.common.Constant;
import com.bjsxt.common.PageInfo;
import com.bjsxt.common.Result;
import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.IUsersService;

import cn.hutool.core.date.DateUtil;

public class UserServiceImpl implements IUsersService {
	
	private UserDao userDao = new UserDao();

	@Override
	public Result login(String username, String password) {
		//根据用户名和密码查询用户对象
		Users users = userDao.selectOne(username, password);
		//如果不存在 则说明 账号或者密码不正确
		if(users == null) {
			return new Result(CodeMsg.USER_ACCOUNT_ERROR);
		}
		//判断用户状态 在职还是离职
		if(!Constant.USER_STATE_VALID.equals(users.getState())) {
			return new Result(CodeMsg.USER_INVALID_ERROR);
		}
		//返回result
		return new Result(users);
	}

	@Override
	public Result queryPage(Map<String, Object> param) {
		PageInfo<Users> page = userDao.selectPage(param);
		return new Result(page);
	}

	@Override
	public Result resetPassword(int id) {
		userDao.updatePassword(id,Constant.DEFAULT_PASSWORD);
		return new Result();
	}

	@Override
	public Result quit(int id) {
		userDao.updateState(id,Constant.USER_STATE_INVALID);
		return new Result();
	}

	@Override
	public Result add(Users user) {
		//业务数据校验
		//用户名是否存在
		Users u = userDao.selectOneByName(user.getUsername());
		if(u != null) {
			return new Result(CodeMsg.USER_ACCOUNT_EXIST_ERROR);
		}
		//设置默认密码
		user.setPassword(Constant.DEFAULT_PASSWORD);
		user.setCreateTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		user.setModifyTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		userDao.insert(user);
		return new Result();
	}

	@Override
	public Result updatePassoword(Integer id, String confimPassword) {
		userDao.updatePassword(id,confimPassword);
		return new Result();
	}

	@Override
	public Result querySalesman() {
		List<Users> users = userDao.selectListByRoleState(Constant.USER_ROLE_SALESMAN,Constant.USER_STATE_VALID);
		return new Result(users);
	}

	@Override
	public Result updateUserImg(Integer id, String url) {
		userDao.updateUserImage(id,url);
		return new Result();
	}

}
