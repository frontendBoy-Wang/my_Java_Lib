package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bjsxt.common.CodeMsg;
import com.bjsxt.common.Result;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.IUsersService;
import com.bjsxt.service.impl.UserServiceImpl;
import com.bjsxt.util.RespUtil;
import com.bjsxt.util.WebUtil;

import cn.hutool.core.util.StrUtil;

/**
 * @ClassName: UserController 
 * @Description: 用户控制类
 * @author: Mr.T
 * @date: 2020年6月28日 下午4:37:03
 */
@WebServlet("/user.do")
@MultipartConfig  //这个注解 表示 servlet 支持二进制数据流解析
public class UserController extends HttpServlet{

	private static final long serialVersionUID = -1475978583788688641L;
	
	private IUsersService userService = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");	String service = req.getParameter("service");
		try {
			this.getClass().getDeclaredMethod(service, HttpServletRequest.class,HttpServletResponse.class).invoke(this,req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * @Title: login
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午4:39:41 
	 * @Description: 用户登录控制类
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");
		//获取用户名
		String username = req.getParameter("username");
		//获取用户密码
		String password = req.getParameter("password");
		//根据用户名和密码查询用户
		Result rs = userService.login(username, password);
		//如果响应的业务码不是成功响应码则直接将数据返回给浏览器
		if(!rs.getCode().equals(CodeMsg.SUCCESS.getCode())) {
			RespUtil.write(resp, rs);
			return ;
		}
		//将当前登录用户 放入session
		WebUtil.saveCurrentUser(req, rs.getData());
		//rs中有账号信息 直接返回rs 数据不安全
		RespUtil.write(resp, new Result());
	}
	/**
	 * @Title: page
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午6:04:10 
	 * @Description: 分页数据接口
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void page(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");//获取所有的查询参数
		Map<String,Object> param = new HashMap<>();
		String page = req.getParameter("page");
		if(StrUtil.isNotBlank(page)) {
			param.put("page", page);
		}
		String limit = req.getParameter("limit");
		if(StrUtil.isNotBlank(limit)) {
			param.put("limit", limit);
		}
		String username = req.getParameter("username");
		if(StrUtil.isNotBlank(username)) {
			param.put("username", username);
		}
		String realName = req.getParameter("realName");
		if(StrUtil.isNotBlank(realName)) {
			param.put("realName", realName);
		}
		String role = req.getParameter("role");
		if(StrUtil.isNotBlank(role)) {
			param.put("role", role);
		}
		String state = req.getParameter("state");
		if(StrUtil.isNotBlank(state)) {
			param.put("state", state);
		}
		Result rs = userService.queryPage(param);
		RespUtil.write(resp, rs);
	}
	/**
	 * @Title: resetPwd
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午2:42:49 
	 * @Description: 重置密码
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void resetPwd(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");resp.setContentType("text/html;charset=utf-8");String id = req.getParameter("id");
		//根据ID 重置密码
		Result rs = userService.resetPassword(Integer.parseInt(id));
		RespUtil.write(resp, rs);
	}
	/**
	 * @Title: quit
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午2:57:41 
	 * @Description: 员工离职
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void quit(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");	String id = req.getParameter("id");
		//根据ID 重置密码
		Result rs = userService.quit(Integer.parseInt(id));
		RespUtil.write(resp, rs);
	}
	
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午4:00:17 
	 * @Description: 新增用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");	String realName = req.getParameter("realName");
		String username = req.getParameter("username");
		String state = req.getParameter("state");
		String role = req.getParameter("role");
		Users user = new Users();
		user.setRealName(realName);
		user.setUsername(username);
		user.setState(Integer.parseInt(state));
		user.setRole(Integer.parseInt(role));
		//新增用户
		Result rs = userService.add(user);
		RespUtil.write(resp, rs);
	}
	
	
	/**
	 * @Title: updatePwd
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午4:49:40 
	 * @Description: 修改密码
	 * 	1.再次确认的新密码要和新密码一致
	 * 
	 * 	2.输入的原密码要和实际原密码一致
	 * 
	 *  3.则使用新密码替代数据中的密码
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void updatePwd(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");	//输入的原密码
		String password = req.getParameter("password");
		//从session中获取当前用户
		Users user = WebUtil.getCurrentUser(req);
		//对比输入的原密码和当前密码是否一致
		if(user == null) {//如果为null 说明登录信息失效
			RespUtil.write(resp, new Result(CodeMsg.USER_LOGIN_INVALID_ERROR));
			return;
		}
		//对比密码是否一致
		if(!StrUtil.equals(password, user.getPassword())) {
			RespUtil.write(resp, new Result(CodeMsg.USER_PASSWORD_ERROR));
			return;
		}
		//新密码和原密码对比
		String confirmPassword = req.getParameter("confirmPassword");
		if(StrUtil.equals(confirmPassword, user.getPassword())) {
			RespUtil.write(resp, new Result(CodeMsg.USER_PASSWORD_ISSAME_ERROR));
			return;
		}
		Result rs = userService.updatePassoword(user.getId(),confirmPassword);
		//从session中删除当前用户
		if(CodeMsg.SUCCESS.getCode().equals(rs.getCode())) {
			WebUtil.removeCurrentUser(req);
		}
		RespUtil.write(resp, rs);
	}
	
	
	/**
	 * @Title: loginOut
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午5:39:31 
	 * @Description: 退出
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void loginOut(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");	resp.setContentType("text/html;charset=utf-8");//删除session中的用户
		WebUtil.removeCurrentUser(req);
		//跳转登录页面  /cms
		String  webRoot = req.getContextPath();
		resp.sendRedirect(webRoot +"/index.jsp");
	}
	
	/**
	 * @Title: allSalesman
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午4:17:43 
	 * @Description: 获取所有业务员
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void allSalesman(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");Result rs = userService.querySalesman();
		RespUtil.write(resp, rs);
	}
	/**
	 * @Title: uploadImg
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午4:18:01 
	 * @Description: 上传图片
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	protected void uploadImg(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");resp.setContentType("text/html;charset=utf-8");	//获取图片数据
		Part part = req.getPart("userImg");
		//文件名称
		String fileRealName = this.getFileName(part);
		//userImages 的绝对路径
		String realPath = req.getServletContext().getRealPath("userImages");
		//part.get
		//1.jpg   保存能使用 1.jpg吗？  张三  1.jpg    李四  1.jpg
		String fileName = WebUtil.getCurrentUser(req).getId()+fileRealName.substring(fileRealName.indexOf("."));
		//File.separator  在windows 操作系统中盘符路径分割符 \  在linux 操作系统中 盘符路径分隔符 /
		//图片保存的路径  
		String filePath = realPath +File.separator+ fileName;
		//保存文件
		part.write(filePath);
		//网络访问路径
		String url = "/userImages/"+fileName;
		//修改用户图片URL
		Result rs = userService.updateUserImg(WebUtil.getCurrentUser(req).getId(),url);
		RespUtil.write(resp,rs);
	}
	
	/**
	 * @Title: getFileName
	 * @author: Mr.T   
	 * @date: 2020年7月1日 下午4:44:23 
	 * @Description: 获取文件名称
	 * @param part
	 * @return
	 * @return: String
	 */
	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		//form-data; name="userImg"; filename="02.jpg"
		String[] fileInfo = header.split(";");
		String fileName = fileInfo[2].trim();// filename="02.jpg"
		fileName = fileName.substring(fileName.indexOf("\"")+1,fileName.lastIndexOf("\""));
		return fileName;
	}

}
