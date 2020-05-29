package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/Demo06Request")
public class Demo06Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数
        /**
         * 1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
         * 2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
         * 3. Enumeration<String> getParameterNames():获取所有请求的参数名称
         * 4. Map<String,String[]> getParameterMap():获取所有参数的map集合
         */

        //1. String getParameter(String name):根据参数名称获取参数值
        String username = request.getParameter("username");
        /*System.out.println("post");
        System.out.println(username);*/

        //2. String[] getParameterValues(String name):根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        /*for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        //3. Enumeration<String> getParameterNames():获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("---------");
        }

        //4. Map<String,String[]> getParameterMap():获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //获取键值
            String[] value = parameterMap.get(name);
            System.out.println(name);
            for (String s : value) {
                System.out.println(s);
            }
            System.out.println(">>>>>>>>>>");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数
        //1. String getParameter(String name):根据参数名称获取参数值
        /*String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
        this.doPost(request,response);
    }
}
