package com.bjsxt.service;

import java.util.Map;

import com.bjsxt.common.Result;
import com.bjsxt.pojo.VisitLog;

/**
 * @ClassName: IVisitLogService 
 * @Description: 拜访记录业务类
 * @author: Mr.T
 * @date: 2020年7月1日 下午2:43:07
 */
public interface IVisitLogService {
	
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午2:43:39 
	 * @Description: 新增拜访记录
	 * @param visitLog
	 * @return
	 * @return: Result
	 */
	public Result  add(VisitLog visitLog);
	/**
	 * @Title: queryPie
	 * @author: Mr.T   
	 * @date: 2020年7月2日 下午4:47:33 
	 * @Description: 拜访记录数据接口
	 * @param param
	 * @return
	 * @return: Result
	 */
	public Result queryPie(Map<String, Object> param);

}
