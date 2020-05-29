package 基础加强.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import 基础加强.junit.Demo01Junit;

public class CalculatorTest {
    /**
     * 初始化方法:
     * 用于资源申请,所有方法在执行之前都会执行该方法
     */
    @Before
    public  void init(){
        System.out.println("init...");
    }
    /**
     * 释放资源
     * 在所有测试方法执行完之后.都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }

    /**
     * 测试add方法
     */
    @Test
    public void testAdd() {
        //System.out.println("已经执行");
        Demo01Junit demo01Junit = new Demo01Junit();
        System.out.println("testAdd...");
        int add = demo01Junit.add(12, 324);
        int sub = demo01Junit.sub(324, 32);
        System.out.println(add);
        System.out.println("testsub");
        //断言
        Assert.assertEquals(336,add);
    }
}
