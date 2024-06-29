package org.example.a07_lazy.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 单例对象的延迟加载
 * 多例@Lazy失效
 *
 * @author qlk
 */
@Component
//@Scope(scopeName = "prototype")
@Lazy(true)
public class LogUtil {

    public LogUtil() {
        System.out.println("LogUtil对象创建");
    }

    public void printLog() {
        System.out.println("模拟记录日志");
    }
}

/*
@Lazy

用于指定单例bean对象的创建时机。
在没有使用此注解时，单例bean的生命周期与容器相同。
但是当使用了此注解之后，单例对象的创建时机变成了第一次使用时创建。注意：这不是延迟加载思想（因为不是每次使用时都创建，只是第一次创建的时机改变了）。

此注解只对单例bean对象起作用，当指定了@Scope注解的prototype取值后，此注解不起作用。
 */