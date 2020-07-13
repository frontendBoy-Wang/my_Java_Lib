package com.bjsxt.common;

/**
 * @ClassName: CodeMsg 
 * @Description: 业务码和业务信息的枚举类
 * 	所有返回的业务信息都是 CodeMsg枚举中的一个值 不允许单独在类中使用
 * 	数字或者字符串，必须是CodeMsg枚举中的值。
 * @author: Mr.T
 * @date: 2020年6月28日 下午3:30:02
 */
public enum CodeMsg {
	
	SUCCESS(200,"操作成功"),
	/*
	 * 	业务枚举定义规范如下：
	 * 	以4 开头表示异常 模块xxx模块中具体业务异常码xxx 
	 * 	以三位一组只是为了后续的模块和异常进行预留位。
	 * 	例如：用户模块是001 账号密码不对001 ===>4001001
	 */
	USER_ACCOUNT_ERROR(400101,"用户账号或密码错误"),
	USER_INVALID_ERROR(400102,"用户账户已失效"),
	USER_ACCOUNT_EXIST_ERROR(400103,"用户名已被使用"),
	USER_LOGIN_INVALID_ERROR(400104,"用户登录已失效,请重新登录"),
	USER_PASSWORD_ERROR(400105,"用户密码错误"),
	USER_PASSWORD_ISSAME_ERROR(400106,"新密码与原密码相似"),
	
	CUSTOMER_PHONE_EXIST_ERROR(400201,"手机号已存在"),
	;
	
	
	
	
	/**
	 *	业务消息
	 */
	Integer code;
	/**
	 * 	业务消息
	 */
	String msg;
	
	CodeMsg(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
