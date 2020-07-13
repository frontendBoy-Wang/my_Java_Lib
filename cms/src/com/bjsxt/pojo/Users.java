package com.bjsxt.pojo;

/**
 * @ClassName: Users 
 * @Description: 用户实体类
 * @author: Mr.T
 * @date: 2020年6月28日 下午4:41:37
 */
public class Users {
	
	private Integer id; //用户ID
	private String username;//用户名
	private String password;//密码
	private String realName;//真实姓名
	private Integer role;//角色
	private Integer state;//状态
	private String img;//头像地址
	private String createTime; //创建时间
	private String modifyTime;//修改时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
