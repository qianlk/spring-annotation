package org.example.b03_anno_general.utils;

import org.aspectj.lang.annotation.*;
import org.example.b03_anno_general.domain.User;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
@Aspect
public class LogUtil {

    @Pointcut(value = "execution(* org.example.b03_anno_general.service.impl.*.*(..)) && args(user,id)", argNames = "user,id")
    private void pointcut(User user, String id) {

    }

    // 同一个切面中,相同类型的切面顺序
    // 按照ascii码表中的数字大小决定
    // Order注解此处不生效, @Order决定类的创建时机,而在方法级别上,无法生效
    // 注意,如果方法重载也相同, 也是按照码表进行按顺序执行
    @Before(value = "pointcut(user, id)", argNames = "user,id")
    public void abeforePrintLog1(User user, String id){
        System.out.println(user + "," + id);
        System.out.println("前置通知增强了: abeforePrintLog1");
    }

    /**
     * 前置通知
     * 切入点方法执行之前执行 1
     * 可以取到参数进行增强
     */
    @Before(value = "pointcut(user, id)", argNames = "user,id")
    public void beforePrintLog(User user, String id){
        System.out.println(user + "," + id);
        System.out.println("前置通知增强了");
    }

    /**
     * 最终通知
     * 切入点方法执行之后执行 2
     */
    @After(value = "pointcut(user, id)", argNames = "user,id")
    public void afterPrintLog(User user, String id) {
        System.out.println(user + "," + id);
        System.out.println("最终通知增强了");
    }

    /**
     * 后置通知
     * 切入点方法执行成功后,方法返回前执行 3
     */
    @AfterReturning(pointcut = "execution(* org.example.b03_anno_general.service.impl.*.*(..))", returning = "obj")
    public void afterReturningPrintLog(Object obj) {
        System.out.println("后置通知增强了" + obj);
    }

    /**
     * 异常通知
     * 切入点执行失败后,产生异常之后 4
     */
    @AfterThrowing(value = "execution(* org.example.b03_anno_general.service.impl.*.*(..))", throwing = "e")
    public void afterThrowingPrintLog(Throwable e) {
        System.out.println("异常通知增强了" + e);
    }

}
