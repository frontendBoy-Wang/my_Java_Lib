package com.bjsxt.pojo;

/**
 * @ClassName: VisitLog 
 * @Description: 拜访记录
 * @author: Mr.T
 * @date: 2020年7月1日 下午2:38:37
 */
public class VisitLog {
	
	private String visitTime; //拜访时间
	private Integer userId;  //业务员ID
	private String name;//业务员名称
	private Integer custId;  //客户ID
	private String visitDesc;  //拜访信息
	private String  createTime; //创建时间
	private Long value;//数量
	
	
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getVisitDesc() {
		return visitDesc;
	}
	public void setVisitDesc(String visitDesc) {
		this.visitDesc = visitDesc;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
