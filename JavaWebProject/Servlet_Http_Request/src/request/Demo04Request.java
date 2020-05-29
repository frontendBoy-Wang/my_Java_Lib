package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo04Request")
public class Demo04Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/**
 * 2. 获取请求头数据
 * * 方法：
 * 	* (*)String getHeader(String name):通过请求头的名称获取请求头的值
 * 	* Enumeration<String> getHeaderNames():获取所有的请求头名称
 */
        //演示获取请求头数据:referer
        String referer = request.getHeader("referer");
        System.out.println("referer = " + referer);//referer = http://localhost/login.html
        //放到链
        if (referer!=null){
            if (referer.contains("/")){
                System.out.println("看电影");
            }else {
                //盗链
                System.out.println("看电影来优酷");
            }
        }

    }
}
