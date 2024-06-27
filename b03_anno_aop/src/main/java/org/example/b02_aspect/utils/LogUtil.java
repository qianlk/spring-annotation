package org.example.b02_aspect.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.b01_enable_aspectj_autoproxy.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
// @Aspect 表明当前类是一个切面类
// perthis, 指定当前切面类是一个多例的,要和 @Scope("prototype") 一起; 如果使用了singleton会报错
//@Aspect(value = "perthis(execution(* org.example.b02_aspect.service.impl.*.*(..)))")
//@Scope("prototype")
//@Scope("singleton")

@Aspect
@Order(1)
public class LogUtil {

//    @Pointcut(value = "execution(* org.example.b02_aspect.service.impl.*.*(..)) && args(user)", argNames = "user")
    @Pointcut(value = "execution(* org.example.b02_aspect.service.impl.*.*(..)) && args(user)")
    public void pointcut(User user) {

    }
//    private void pointcut(User user) {
//
//    }

    /**
     * 用于配置当前方法是一个前置通知
     */
//    @Before("execution(* org.example.service.impl.*.*(..))")
    @Before(value = "pointcut(user)", argNames = "user")
    public void printLog(User user){
        System.out.println("执行打印日志的功能" + user);
    }

}
