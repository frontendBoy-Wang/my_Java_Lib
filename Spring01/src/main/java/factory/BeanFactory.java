package factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName:BeanFactory
 * @Description: 一个创建Bean对象的工厂。Bean：有可重用的组件
 * JavaBean：用Java语言编写的可重用组件
 * javabean>实体类
 * 他就是创建我们的service和dao对象
 * 第一个：需要一个配置文件来配置service和dao，配置内容：唯一标识=全限定类名(key=value)
 * 第二个：通过读取配置文件中的配置的内容，反射创建对象
 * <p>
 * 配置文件可以是xml或者properties
 * @Author: 汪满青
 * @Date: 2020-07-14 13:43
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties;
    private static Map<String, Object> beans;

    //使用静态代码块位Properties对象赋值
    static {

        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件的流对象
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            assert is != null;
            properties.load(is);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = properties.keys();
            while (keys.hasMoreElements()) {
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入map容器之中
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    /**
     * @Title:
     * @Author: 汪满青
     * @Description: 根据Bean的名称获取bean的对象
     * @Date: 2020/7/14-17:32
     * @Param: [beanName]
     * @return: java.lang.Object
     **/
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
    
    /**
     * @Title:getBean
     * @Author: 汪满青
     * @Description: 根据Bean的名称获取bean的对象
     * @Date: 2020/7/14-13:59
     * @Param: [beanName]
     * @return: java.lang.Object
     **/
  /*  public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = properties.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();
            //System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
