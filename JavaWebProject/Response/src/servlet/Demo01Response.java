package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo01Response")
public class Demo01Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1....");
        //访问/responseDemo1，会自动跳转到/ responseDemo2资源
        //1.设置状态码为302
        //response.setStatus(302);
        //2.设置响应头location
        //response.setHeader("location", "/demo02Response");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简单的方法
        response.sendRedirect(contextPath + "/demo02Response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
