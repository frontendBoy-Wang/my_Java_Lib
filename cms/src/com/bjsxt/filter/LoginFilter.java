package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Users;
import com.bjsxt.util.WebUtil;

/**
 * @ClassName: LoginFilter 
 * @Description: 登录拦截器
 * 	如果用户没有登录  则进行登录
 * 	如果用户登录了  则不管
 * 	
 * 	不拦截那些 ：  登录页面     index.jsp    redirect.jsp   css 文件不拦截  js 文件不拦截
 * 		图片也不拦截
 *  
 *  拦截 ：  jsp   *.do
 * 
 * 	此时只拦截  *.do 和 *.jsp 后缀的请求  但是 在*.jsp中又要排除   index.jsp redirect.jsp 
 * 
 * 		*.do  登录请求不能拦截    user.do中 service的值为 login的不拦截
 * 
 * @author: Mr.T
 * @date: 2020年7月1日 下午5:18:01
 */
@WebFilter(urlPatterns= {"*.do","*.jsp"})
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//获取请求的资源路径
		String uri = req.getRequestURI();
		//从session获取用户
		Users user = WebUtil.getCurrentUser(req);
		//用户已经登录  不拦截
		if(user != null) {
			//放行
			chain.doFilter(request, response);
			return;
		}
		//需要拦截的操作  将不需要拦截的放行
		if(uri.endsWith("index.jsp") || uri.endsWith("redirect.jsp")) {
			//放行
			chain.doFilter(request, response);
			return;
		}
		//如果为登录请求 则也放行
		String service = req.getParameter("service");
		if(uri.endsWith("user.do") && "login".equals(service)) {
			//放行
			chain.doFilter(request, response);
			return;
		}
		//其他行为 则跳转到登录页面
		resp.sendRedirect(req.getContextPath()+"/redirect.jsp");
	}

	@Override
	public void destroy() {
		
	}

}
