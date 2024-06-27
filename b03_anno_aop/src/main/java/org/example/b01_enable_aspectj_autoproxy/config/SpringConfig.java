package org.example.b01_enable_aspectj_autoproxy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qlk
 */
@Configuration
@ComponentScan("org.example.b01_enable_aspectj_autoproxy")
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = true)  // 开启spring注解的aop支持
public class SpringConfig {
}
