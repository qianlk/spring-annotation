package org.example.a02_componentscan.utils;

import org.springframework.stereotype.Component;

/**
 * @author qlk
 */
@Component("logUtil")
public class LogUtil {

    public void printLog() {
        System.out.println("输出日志");
    }
}
