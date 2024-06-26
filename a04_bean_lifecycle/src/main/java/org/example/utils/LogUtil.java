package org.example.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author qlk
 */
@Component
//@Scope("prototype")  // 当指定为多例时,对象的销毁方法只会由垃圾回收器触发
public class LogUtil {

    public LogUtil() {
        System.out.println("对象创建了");
    }

    @PostConstruct
    public void init() {
        System.out.println("对象初始化了");
    }

    public void printLog() {
        System.out.println("模拟日志打印");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("对象销毁了");
    }
}
