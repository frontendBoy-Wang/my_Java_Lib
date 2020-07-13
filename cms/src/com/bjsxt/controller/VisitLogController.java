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
import com.bjsxt.pojo.VisitLog;
import com.bjsxt.service.IVisitLogService;
import com.bjsxt.service.impl.VisitLogServiceImpl;
import com.bjsxt.util.RespUtil;
import com.bjsxt.util.WebUtil;

import cn.hutool.core.util.StrUtil;

@WebServlet("/visitlog.do")
public class VisitLogController extends HttpServlet {

	private static final long serialVersionUID = -7878666788440788969L;

	
	private IVisitLogService visitLogService = new VisitLogServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");
		resp.setContentType("text/html;charset=utf-8");	String service = req.getParameter("service");
		try {
			this.getClass().getDeclaredMethod(service, HttpServletRequest.class,HttpServletResponse.class).invoke(this,req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午2:47:18 
	 * @Description: 新增拜访记录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");resp.setContentType("text/html;charset=utf-8");String visitTime = req.getParameter("visitTime");
		String custId = req.getParameter("id");
		String visitDesc = req.getParameter("visitDesc");
		VisitLog log = new VisitLog();
		log.setVisitTime(visitTime);
		log.setCustId(Integer.parseInt(custId));
		log.setVisitDesc(visitDesc);
		log.setUserId(WebUtil.getCurrentUser(req).getId());
		Result rs = visitLogService.add(log);
		RespUtil.write(resp, rs);
	}
	
	/**
	 * @Title: pie
	 * @author: Mr.T   
	 * @date: 2020年7月2日 下午4:47:14 
	 * @Description: 拜访记录数据接口
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void pie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setHeader("Content-Type", "text/html; charset=UTF-8");resp.setContentType("text/html;charset=utf-8");String minVisitTime = req.getParameter("minVisitTime");
		String maxVisitTime = req.getParameter("maxVisitTime");
		Map<String,Object> param = new HashMap<>();
		if(StrUtil.isNotBlank(minVisitTime)) {
			param.put("minVisitTime", minVisitTime);
		}
		if(StrUtil.isNotBlank(maxVisitTime)) {
			param.put("maxVisitTime", maxVisitTime);
		}
		Result rs = visitLogService.queryPie(param);
		RespUtil.write(resp, rs);
	}
}
