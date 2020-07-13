package com.bjsxt.common;

/**
 * @ClassName: Constant 
 * @Description: 所有常量的接口
 * @author: Mr.T
 * @date: 2020年6月28日 下午3:28:46
 */
public interface Constant {

	/**
	 * 	默认的密码
	 */
	String DEFAULT_PASSWORD = "123456";
	/**
	 * 管理员
	 */
	Integer USER_ROLE_ADMIN = 1;
	/**
	 * 业务员
	 */
	Integer USER_ROLE_SALESMAN = 2;
	
	/**
	 * 	用户状态 有效:  1
	 */
	Integer USER_STATE_VALID = 1;
	/**
	 *  	用户状态 无效、离职 ：2
	 */
	Integer USER_STATE_INVALID = 2;
	
	/**
	 * session中当前用户的key
	 */
	String SESSION_CURRENT_USER = "user";
	/**
	 *	时间格式 ：yyyy-MM-dd HH:mm:ss
	 */
	String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

}
