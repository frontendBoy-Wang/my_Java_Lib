package com.bjsxt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.common.Result;
import com.bjsxt.pojo.Customer;
import com.bjsxt.service.ICustomerService;
import com.bjsxt.service.impl.CustomerServiceImpl;
import com.bjsxt.util.RespUtil;
import com.bjsxt.util.WebUtil;

import cn.hutool.core.util.StrUtil;

@WebServlet("/customer.do")
public class CustomerController extends HttpServlet {

	private static final long serialVersionUID = 1117832477591608429L;
	
	private ICustomerService customerService = new CustomerServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");resp.setContentType("text/html;charset=utf-8");resp.setCharacterEncoding("utf-8");
		String service = req.getParameter("service");
		try {
			this.getClass().getDeclaredMethod(service, HttpServletRequest.class,HttpServletResponse.class).invoke(this,req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * @Title: page
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午2:41:01 
	 * @Description: 分页接口
	 * 	 	搜索的参数
	 * 		客户名 		custName   
	 * 		客户公司  	company    
	 * 		职位  		position   
	 * 		工资范围        	最低工资 minSalary  最高工资 maxSalary
	 * 		电话 		phone	
	 * 		性别  		sex
	 * 		状态  		state
	 * 		业务员 		userId
	 * 		创建时间          minCreateTime  maxCreateTime
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void page(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//获取所有的查询参数
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");resp.setContentType("text/html;charset=utf-8");resp.setCharacterEncoding("utf-8");
		Map<String,Object> param = new HashMap<>();
		String page = req.getParameter("page");
		if(StrUtil.isNotBlank(page)) {
			param.put("page", page);
		}
		String limit = req.getParameter("limit");
		if(StrUtil.isNotBlank(limit)) {
			param.put("limit", limit);
		}
		String custName = req.getParameter("custName");
		if(StrUtil.isNotBlank(custName)) {
			param.put("custName", custName);
		}
		String company = req.getParameter("company");
		if(StrUtil.isNotBlank(company)) {
			param.put("company", company);
		}
		String position = req.getParameter("position");
		if(StrUtil.isNotBlank(position)) {
			param.put("position", position);
		}
		String minSalary = req.getParameter("minSalary");
		if(StrUtil.isNotBlank(minSalary)) {
			param.put("minSalary", minSalary);
		}
		String maxSalary = req.getParameter("maxSalary");
		if(StrUtil.isNotBlank(maxSalary)) {
			param.put("maxSalary", maxSalary);
		}
		String phone = req.getParameter("phone");
		if(StrUtil.isNotBlank(phone)) {
			param.put("phone", phone);
		}
		String sex = req.getParameter("sex");
		if(StrUtil.isNotBlank(sex)) {
			param.put("sex", sex);
		}
		String state = req.getParameter("state");
		if(StrUtil.isNotBlank(state)) {
			param.put("state", state);
		}
		String userId = req.getParameter("userId");
		if(StrUtil.isNotBlank(userId)) {
			param.put("userId", userId);
		}
		String minCreateTime = req.getParameter("minCreateTime");
		if(StrUtil.isNotBlank(minCreateTime)) {
			param.put("minCreateTime", minCreateTime);
		}
		String maxCreateTime = req.getParameter("maxCreateTime");
		if(StrUtil.isNotBlank(maxCreateTime)) {
			param.put("maxCreateTime", maxCreateTime);
		}
		Result rs = customerService.queryPage(param);
		RespUtil.write(resp, rs);
	}
	
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午4:36:55 
	 * @Description: 新增客户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");resp.setCharacterEncoding("utf-8");
		String custName = req.getParameter("custName");
		String company = req.getParameter("company");
		String position = req.getParameter("position");
		String salary = req.getParameter("salary");
		String phone = req.getParameter("phone");
		String sex = req.getParameter("sex");
		String state = req.getParameter("state");
		Customer customer = new Customer();
		customer.setCustName(custName);
		customer.setCompany(company);
		customer.setPosition(position);
		customer.setSalary(Integer.parseInt(salary));
		customer.setPhone(phone);
		customer.setSex(Integer.parseInt(sex));
		customer.setState(Integer.parseInt(state));
		customer.setUserId(WebUtil.getCurrentUser(req).getId());
		Result rs = customerService.add(customer);
		RespUtil.write(resp, rs);
		
	}
	
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午5:24:42 
	 * @Description: 修改客户信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");	resp.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String custName = req.getParameter("custName");
		String company = req.getParameter("company");
		String position = req.getParameter("position");
		String salary = req.getParameter("salary");
		String phone = req.getParameter("phone");
		String sex = req.getParameter("sex");
		String state = req.getParameter("state");
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setCustName(custName);
		customer.setCompany(company);
		customer.setPosition(position);
		customer.setSalary(Integer.parseInt(salary));
		customer.setPhone(phone);
		customer.setSex(Integer.parseInt(sex));
		customer.setState(Integer.parseInt(state));
		Result rs = customerService.update(customer);
		RespUtil.write(resp, rs);
	}
	/**
	 * @Title: batchDelete
	 * @author: Mr.T   
	 * @date: 2020年6月30日 下午5:33:36 
	 * @Description: 批量删除数据
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void batchDelete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setHeader("Content-Type", "text/html; charset=UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String[] id = req.getParameterValues("id");
		Result rs = customerService.batchDelete(id);
		RespUtil.write(resp, rs);
	}
	/**
	 * @Title: setSalesman
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午2:26:24 
	 * @Description: 修改业务员ID
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void setSalesman(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String[] id = req.getParameterValues("id");
		String userId = req.getParameter("userId");
		Result rs = customerService.updateUserId(userId,id);
		RespUtil.write(resp, rs);
	}
	
	
}
