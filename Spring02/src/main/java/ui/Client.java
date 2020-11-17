package ui;

import dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.IAccountService;

/**
 * @ClassName:Client
 * @Description: 模拟一个表现层，用于调用业务层
 * @Author: 汪满青
 * @Date: 2020-07-14 13:34
 */
public class Client {

    /**
     * @Title:
     * @Author: 汪满青
     * @Description:
     * 获取spring的核心容器，并且根据ID获取对象
     *  ApplicationContext的三个实现类：
     *            ClassPathXmlApplicationContext:可以加载类路径下的配置文件。要求配置文件必须在类路径下，否则加载不了（推荐）
     *            FileSystemXmlApplicationContext:可以加载磁盘任意路径下的配置文件（但是必须要有访问权限）
     *            AnnotationConfigApplicationContext:用于读取注解创建容器的
     *  核心容器的两个接口引发的问题：
     *      ApplicationContext：在构建核心容器时创建对象的方式是采用立即加载的方式，只要读取完配置文件马上就创建配置文件中的配置对象
     *      BeanFactory：
     * @Date: 2020/7/16-17:33
     * @Param: [args]
     * @return: void
     **/
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao dao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(dao);
    }
}
