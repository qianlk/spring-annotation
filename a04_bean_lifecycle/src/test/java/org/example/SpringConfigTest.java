package org.example;


import org.example.utils.LogUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qlk
 */
public class SpringConfigTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        LogUtil logUtil = ac.getBean("logUtil", LogUtil.class);

        logUtil.printLog();

        ac.close();
    }

}