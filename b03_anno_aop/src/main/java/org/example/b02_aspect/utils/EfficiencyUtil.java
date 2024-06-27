package org.example.b02_aspect.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.b02_aspect.domain.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 统计方法执行效率
 *
 * @author qlk
 */
@Component
@Aspect
@Order(value = 2)  // 多个切面的执行顺序, 默认是按照类的首字母顺序, 可以通过指定 order 越小的值越先执行
public class EfficiencyUtil {

    private Long time;

    /**
     * 前置通知
     */
    @Before("execution(* org.example.b02_aspect.service.impl.*.*(..))")
    public void before() {
        time = System.currentTimeMillis();
        System.out.println("方法执行开始时间: " + time);
    }

    /**
     * 最终通知
     */
    @After(value = "org.example.b02_aspect.constants.MyPointCut.pointcut(user)", argNames = "user")
    public void after(User user) {
        System.out.println("方法执行时间: " + (System.currentTimeMillis() - time) + " , " + user);
    }


}
