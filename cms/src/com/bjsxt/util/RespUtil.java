package com.bjsxt.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.bjsxt.common.Result;

/**
 * @ClassName: RespUtil 
 * @Description: 响应数据工具类
 * @author: Mr.T
 * @date: 2020年6月19日 下午5:48:35
 */
public abstract class RespUtil {
	
	/**
	 * @Title: write
	 * @author: Mr.T   
	 * @date: 2020年6月19日 下午5:49:22 
	 * @Description: 将数据使用json格式返回
	 * @param resp
	 * @param rs
	 * @return: void
	 */
	public static void write(HttpServletResponse resp,Result rs) {
		//将数据转化为JSON字符串
		String result =  JSON.toJSONString(rs);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = resp.getWriter();
			writer.print(result);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			writer.close();
		}
		
	}

}
