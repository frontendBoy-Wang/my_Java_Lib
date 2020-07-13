package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import com.bjsxt.pojo.VisitLog;

/**
 * @ClassName: VisitLogDao 
 * @Description: 拜访记录数据操作类
 * @author: Mr.T
 * @date: 2020年7月1日 下午2:40:27
 */
public class VisitLogDao extends BaseDao {
	
	/**
	 * @Title: insert
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午2:42:43 
	 * @Description: 新增拜访记录
	 * @param log
	 * @return: void
	 */
	public void insert(VisitLog log){
		String sql = "insert  into visit_log value(?,?,?,?,?)";
		super.update(sql, log.getVisitTime(),log.getUserId(),log.getCustId(),log.getVisitDesc(),log.getCreateTime());
	}

	public List<VisitLog> selectPie(Map<String, Object> param) {
		String sql = "SELECT user_id as userId,count(user_id)  as value from visit_log where 1=1 ";
		if(param.containsKey("minVisitTime")) {
			sql = sql + " and visit_time >'"+param.get("minVisitTime")+"' ";
		}
		if(param.containsKey("maxVisitTime")) {
			sql = sql + " and visit_time <='"+param.get("maxVisitTime")+"' ";
		}
		sql = sql + "  GROUP BY user_id ";
		return super.selectList(sql, VisitLog.class);
	}

}
