package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/demo05ServletContext")
public class Demo05ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ServletContext功能:
        1.获取MIME类型:

        2.域对象:共享数据
        3.获取文件的真实(服务器)路径
*/

        //2.通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //获取文件路径
        String b = context.getRealPath("/b.txt");//Web目录下的资源访问
        System.out.println(b);
        //File file=new File(realPath);
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);
        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
