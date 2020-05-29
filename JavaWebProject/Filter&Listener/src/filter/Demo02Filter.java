package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Demo02Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterdemo02执行了");
        //放行
        chain.doFilter(req, resp);
        System.out.println("filterdemo02回来了");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
