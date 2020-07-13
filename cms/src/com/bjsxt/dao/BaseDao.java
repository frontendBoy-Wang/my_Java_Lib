package com.bjsxt.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bjsxt.common.PageInfo;
import com.bjsxt.util.JdbcUtil;

/**
 * @ClassName: BaseDao 
 * @Description: 通用的数据库操作
 * 	查询操作 ： selectAll   selectOne   selectPage
 * 	更新操作 ：insert  insertAotuKey  delete  update
 * 
 * @author: Mr.T
 * @date: 2020年6月13日 上午11:25:36
 */
public abstract class BaseDao {
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月13日 上午11:27:51 
	 * @Description: 通用的数据更新操作
	 * @param sql
	 * @param params
	 * @return
	 * @return: boolean
	 */
	public boolean update(String sql,Object... params) {
		Connection conn = JdbcUtil.getConnection();
		// 2.创建指令对象
		PreparedStatement prep = null;
		int count = 0;
		try {
			prep = conn.prepareStatement(sql);
			// 指令里面可能会有占位符，可能会有参数
			// 存在参数 为指令中的占位符赋值
			if (params != null && params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					prep.setObject(i + 1, params[i]);
				}
			}
			// 执行指令 
			count = prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep);
		}
		return count>0?true:false;
	}
	
	/**
	 * @Title: insertAutoKey
	 * @author: Mr.T   
	 * @date: 2020年6月13日 上午11:28:39 
	 * @Description: 通用的插入 返回生成的主键
	 * @param sql
	 * @param params
	 * @return
	 * @return: Integer
	 */
	public Integer insertAutoKey(String sql,Object... params) {
		Connection conn = JdbcUtil.getConnection();
		// 2.创建指令对象
		PreparedStatement prep = null;
		int key = 0;
		ResultSet rs = null;
		try {
			//设置插入时返回自增涨的主键
			prep = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// 指令里面可能会有占位符，可能会有参数
			// 存在参数 为指令中的占位符赋值
			if (params != null && params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					prep.setObject(i + 1, params[i]);
				}
			}
			//执行指令
			prep.executeUpdate();
			//获取生成自增涨主键值
			rs = prep.getGeneratedKeys();
			rs.next();
			key = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep);
		}
		return key;
	}
	/**
	 * @Title: selectList
	 * @author: Mr.T   
	 * @date: 2020年6月13日 上午11:29:35 
	 * @Description: 通用的查询列表操作
	 * @param <T>
	 * @param sql
	 * @param cls
	 * @param params
	 * @return
	 * @return: List<T>
	 */
	public <T> List<T> selectList(String sql, Class<T> cls, Object... params) {
		// 1.获取连接
		Connection conn = JdbcUtil.getConnection();
		// 2.创建指令对象
		PreparedStatement prep = null;
		// 结果对象
		ResultSet rs = null;
		List<T> data = new ArrayList<T>();
		try {
			// 创建指令对象
			prep = conn.prepareStatement(sql);
			// 为指令的占位符赋值
			if (params != null && params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					prep.setObject(i + 1, params[i]);
				}
			}
			// 执行指令
			// 执行指令 接收结果
			rs = prep.executeQuery();
			// 获取数据元信息
			ResultSetMetaData metaData = rs.getMetaData();
			// 获取列个数
			int count = metaData.getColumnCount();
			//处理结果中的数据
			while(rs.next()) {
				//创建对象
				T obj = cls.newInstance();
				//为对象属性赋值
				for (int i = 1; i <= count; i++) {
					// 获取列别名
					String columnLabel = metaData.getColumnLabel(i);
					// 获取列数据
					Object columnValue = rs.getObject(columnLabel);
					// 根据列名获取属性
					Field field = cls.getDeclaredField(columnLabel);
					// 为属性赋值
					field.setAccessible(true);
					// 赋值
					field.set(obj, columnValue);
				}
				//将对象放入到list中
				data.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			JdbcUtil.close(conn, prep, rs);
		}
		return data;
	}
	
	/**
	 * @Title: selectObj
	 * @author: Mr.T   
	 * @date: 2020年6月13日 上午11:31:22 
	 * @Description: 查询某个对象
	 * @param <T>
	 * @param sql
	 * @param cls
	 * @param params
	 * @return
	 * @return: T
	 */
	public <T> T selectObj(String sql, Class<T> cls, Object... params) {
		List<T> data = this.selectList(sql, cls, params);
		if(data != null && !data.isEmpty()) {
			return data.get(0);
		}
		return null;
	}
	
	/**
	 * @Title: selectPage
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午3:51:42 
	 * @Description: 分页查询公共方法
	 * @param <T>
	 * @param sql
	 * @param cls
	 * @param page
	 * @param limit
	 * @return
	 * @return: PageInfo<T>
	 */
	public <T> PageInfo<T> selectPage(String sql,Class<T> cls,Integer page,Integer limit){
		//获取总数据条数
		Long count = selectCount(sql);
		sql = sql +" limit "+(page - 1)*limit+","+limit;
		List<T> data = this.selectList(sql, cls);
		PageInfo<T> pageInfo = new PageInfo<T>();
		pageInfo.setCount(count);
		pageInfo.setData(data);
		pageInfo.setPage(page);
		pageInfo.setLimit(limit);
		
		return pageInfo;
	}
	
	/**
	 * @Title: selectCount
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午3:50:12 
	 * @Description: 查询符合条件的数据条数
	 * @param sql
	 * @return
	 * @return: Long
	 */
	private Long selectCount(String sql) {
		//拼装为查询符合条件总条数的sql
		sql = "select count(1) from ("+sql+") rs";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			rs.next();
			long count = rs.getLong(1);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep, rs);
		}
		return 0L;
	}

}
