package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet的方法
 */
public class Demo02Servlet implements Servlet {

    /**
     * 初始化方法
     * 在servlet创建时被执行.只执行一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    /**
     * 获取ServletConfig对象
     * servletConfig:Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次servlet被访问时.执行,执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.....");
    }

    /**
     * 获取Servlet的一些信息.作者
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关团时，执行，执行1次。
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
