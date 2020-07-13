package com.bjsxt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName: CharserEncodingFilter
 * @Description: 编码过滤器
 * 全局设置编码
 * @author: Mr.T
 * @date: 2020年6月28日 下午5:36:15
 */
@WebFilter("/*")
public class CharserEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        //设置请求和响应的数据编码
       
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }

}
