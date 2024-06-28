package org.example.b05_anno_others.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qlk
 */
@Configuration
@ComponentScan("org.example.b05_anno_others")
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = true)  // 开启spring注解的aop支持
public class SpringConfig {
}
