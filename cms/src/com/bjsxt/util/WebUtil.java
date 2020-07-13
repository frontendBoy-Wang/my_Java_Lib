package com.bjsxt.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bjsxt.common.Constant;
import com.bjsxt.pojo.Users;

/**
 * @ClassName: WebUtil 
 * @Description: web对象工具类
 * @author: Mr.T
 * @date: 2020年6月28日 下午4:58:15
 */
public class WebUtil {
	
	/**
	 * @Title: saveCurrentUser
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午4:59:52 
	 * @Description: 将当前用户存入session
	 * @param req
	 * @param obj
	 * @return: void
	 */
	public static void saveCurrentUser(HttpServletRequest req,Object obj) {
		HttpSession session = req.getSession();
		session.setAttribute(Constant.SESSION_CURRENT_USER, obj);
	}

	/**
	 * @Title: getCurrentUser
	 * @author: Mr.T   
	 * @date: 2020年6月28日 下午5:01:33 
	 * @Description: 获取session中当前用户
	 * @param req
	 * @return
	 * @return: Users
	 */
	public static Users getCurrentUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute(Constant.SESSION_CURRENT_USER);
		if(obj != null && obj instanceof Users) {
			return (Users) obj;
		}
		return null;
	}
	/**
	 * @Title: removeCurrentUser
	 * @author: Mr.T   
	 * @date: 2020年6月29日 下午5:08:59 
	 * @Description: 将当前登录信息从session中移除
	 * @param req
	 * @return: void
	 */
	public static void removeCurrentUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute(Constant.SESSION_CURRENT_USER);
	}
}
