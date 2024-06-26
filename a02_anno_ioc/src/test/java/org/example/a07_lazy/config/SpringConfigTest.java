package org.example.a07_lazy.config;


import org.example.a07_lazy.utils.LogUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qlk
 */
class SpringConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 不加 @Lazy ,此时LogUtil已经创建了

        LogUtil logUtil = context.getBean("logUtil", LogUtil.class);
        // 加 @Lazy ,此时LogUtil创建
        logUtil.printLog();

        LogUtil logUtil2 = context.getBean("logUtil", LogUtil.class);
        // 单例情况下 @Lazy才会生效, 创建一次, 创建时机在需要使用的时候
        System.out.println(logUtil == logUtil2);
    }

}