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
