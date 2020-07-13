package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import com.bjsxt.common.PageInfo;
import com.bjsxt.pojo.Users;

/**
 * @ClassName: UserDao 
 * @Description: 用户数据操作类
 * @author: Mr.T
 * @date: 2020年6月28日 下午4:44:32
 */
public class UserDao extends BaseDao {
	
	public Users selectOne(String username,String password) {
		String sql = "select id,username,password,real_name as realName,role,state,img from users where username = ? and password = ?";
		return super.selectObj(sql, Users.class, username,password);
	}
	
	/**
	 * @Title: selectPage
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午6:11:33 
	 * @Description: 根据参数查询分页数据
	 * @param param
	 * @return
	 * @return: PageInfo<Users>
	 */
	public PageInfo<Users> selectPage(Map<String, Object> param) {
		Integer page = Integer.parseInt(param.get("page").toString());
		Integer limit = Integer.parseInt(param.get("limit").toString());
		//sql 动态拼接
		String sql = "select id,username,password,real_name as realName,role,state,img,create_time as createTime from users where 1=1";
		if(param.containsKey("username")) {
			sql = sql + " and username like '%"+param.get("username")+"%' ";
		}
		if(param.containsKey("realName")) {
			sql = sql + " and real_name like '%"+param.get("realName")+"%' ";
		}
		if(param.containsKey("role")) {
			sql = sql + " and role ="+param.get("role");
		}
		if(param.containsKey("state")) {
			sql = sql + " and state ="+param.get("state");
		}
		return super.selectPage(sql, Users.class, page, limit);
	}
	/**
	 * @Title: updatePassword
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午2:45:19 
	 * @Description: 根据ID 修改密码
	 * @param id
	 * @param password
	 * @return: void
	 */
	public void updatePassword(int id, String password) {
		String sql = "update users set password = ? where id = ?";
		super.update(sql, password,id);
	}

	public void updateState(int id, Integer state) {
		String sql = "update users set state = ? where id = ?";
		super.update(sql, state,id);
	}
	/**
	 * @Title: selectOneByName
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午4:01:56 
	 * @Description: 根据用户名查询用户
	 * @param username
	 * @return
	 * @return: Users
	 */
	public Users selectOneByName(String username) {
		String sql = "select id,username,password,real_name as realName,role,state,img from users where username = ? ";
		return super.selectObj(sql, Users.class, username);
	}

	public void insert(Users user) {
		String sql = "insert into users(username,password,real_name,role,state,create_time,modify_time) value(?,?,?,?,?,?,?)";
		super.update(sql, user.getUsername(),user.getPassword(),user.getRealName(),user.getRole(),user.getState(),user.getCreateTime(),user.getModifyTime());
	}

	public List<Users> selectListByRoleState(Integer role, Integer state) {
		String sql = "select id,real_name as realName from users where role = ? and state = ?";
		return super.selectList(sql, Users.class, role,state);
	}

	
	public void updateUserImage(Integer id, String url) {
		String sql = "update users set img = ? where id = ?";
		super.update(sql, url,id);
	}

}
