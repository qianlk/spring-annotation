package org.example.b02_aspect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qlk
 */
@Configuration
@ComponentScan("org.example.b02_aspect")
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = true)  // 开启spring注解的aop支持
public class SpringConfig {
}
