package org.example.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
@Aspect
public class LogUtil {

    /**
     * 用于配置当前方法是一个前置通知
     */
//    @Before("execution(* org.example.service.impl.*.*(..))")
    @Before("execution(* org.example.service.impl.*.saveUser(..))")
    public void printLog(){
        System.out.println("执行打印日志的功能");
    }

}
