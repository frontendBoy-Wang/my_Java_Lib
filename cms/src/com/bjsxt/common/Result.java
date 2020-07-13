package com.bjsxt.common;

/**
 * @ClassName: Result 
 * @Description: 业务结果
 * 	在软件设计中，一般返回的数据包含3个部分：
 * 	1.业务码 ：业务成功或者失败的编码
 *  2.业务消息 ：业务消息 业务码对应的信息 
 *  3.业务数据 ：符合当前业务需求的数据
 *  一般，接收数据方，根据业务码进行相关业务操作。
 *  例如：业务异常，则将业务消息展示出来，提示用户什么原因异常
 *  例如：业务正常，则可以选择性的将业务数据进行展示或者进行其他操作
 *  
 * @author: Mr.T
 * @date: 2020年6月19日 下午5:31:01
 */
public class Result {
	
	
	private Integer code;//业务码
	
	private String msg;//业务消息
	
	private Object data;//业务数据
	
	public Result() {
		this.code = CodeMsg.SUCCESS.code;
		this.msg = CodeMsg.SUCCESS.msg;
	}
	
	//操作失败
	public Result(CodeMsg codeMsg) {
		super();
		this.code = codeMsg.code;
		this.msg = codeMsg.msg;
	}
	/**
	 * @Title:Result
	 * @Description:操作成功 且有业务数据
	 * @param data
	 */
	public Result(Object data) {
		this();
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	

}
