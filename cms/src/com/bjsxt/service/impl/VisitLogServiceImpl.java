package com.bjsxt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjsxt.common.Constant;
import com.bjsxt.common.EchartsData;
import com.bjsxt.common.Result;
import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.VisitLogDao;
import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.VisitLog;
import com.bjsxt.service.IVisitLogService;

import cn.hutool.core.date.DateUtil;

public class VisitLogServiceImpl implements IVisitLogService {
	
	private VisitLogDao visitLogDao = new VisitLogDao();
	
	private UserDao userDao = new UserDao();

	@Override
	public Result add(VisitLog visitLog) {
		visitLog.setCreateTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		visitLogDao.insert(visitLog);
		return new Result();
	}

	@Override
	public Result queryPie(Map<String, Object> param) {
		//获取用户的拜访记录
		List<VisitLog> visitData = visitLogDao.selectPie(param);
		//查询所有的有效业务员
		List<Users> users = userDao.selectListByRoleState(Constant.USER_ROLE_SALESMAN, Constant.USER_STATE_VALID);
		//图例数据
		List<String> legendData = new ArrayList<String>();// 张三    李四  王五
		//使用userId 作为key  使用  realName 作为值
		Map<Integer,String> userMap = new HashMap<Integer, String>();//  1  张三     2  李四
		//将业务员名称放入图例
		for (Users user : users) {
			legendData.add(user.getRealName());
			userMap.put(user.getId(), user.getRealName());
		}
		//对象 [{name:'张三',value:10,id:1}]
		for (VisitLog visitLog : visitData) {
			String userName = userMap.get(visitLog.getUserId());
			visitLog.setName(userName);
		}
		//创建Echarts数据对象
		EchartsData echartsData = new EchartsData();
		echartsData.setLegendData(legendData);
		echartsData.setSeriesData(visitData);
		return new Result(echartsData);
	}



}
