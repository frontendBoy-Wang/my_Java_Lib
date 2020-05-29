package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/Demo01Requset")
public class Demo01Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*
        1. 获取请求方式 ：GET
                * String getMethod()
        2. (*)获取虚拟目录：/day14
                * String getContextPath()
        3. 获取Servlet路径: /demo1
                * String getServletPath()
        4. 获取get方式请求参数：name=zhangsan
                * String getQueryString()
        5. (*)获取请求URI：/day14/demo1
                * String getRequestURI():		/day14/demo1
                * StringBuffer getRequestURL()  :http://localhost/day14/demo1
                * URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
				* URI：统一资源标识符 : /day14/demo1					共和国

        6. 获取协议及版本：HTTP/1.1
                * String getProtocol()

        7. 获取客户机的IP地址：
				* String getRemoteAddr()
*/
        // 1. 获取请求方式 ：GET       * String getMethod()
        String method = request.getMethod();
        System.out.println("method = " + method);
        // 2. (*)获取虚拟目录：/day14  * String getContextPath()
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);
        //3. 获取Servlet路径: /demo1  * String getServletPath()
        String servletPath = request.getServletPath();
        System.out.println("servletPath = " + servletPath);
        //4. 获取get方式请求参数：name=zhangsan  * String getQueryString()
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);
        //5. (*)获取请求URI：/day14/demo1
        //* String getRequestURI():		/day14/demo1
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        //* StringBuffer getRequestURL()  :http://localhost/day14/demo1
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        //6. 获取协议及版本：HTTP/1.1   * String getProtocol()
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);
        //7. 获取客户机的IP地址：* String getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);

         }
}
