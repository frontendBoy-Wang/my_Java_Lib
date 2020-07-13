package com.bjsxt.common;

import java.util.List;

/**
 * @ClassName: PageInfo
 * @Description: 分页信息类
 * @author: Mr.T
 * @date: 2020年6月28日 下午3:26:42
 */
public class PageInfo<T> {

	private Integer page;// 当前页码

	private Integer limit;// 每页数据长度

	private Long count;// 总数据条数

	private List<T> data;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
