package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring的配置类
 * @author qlk
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfiguration {
}

/*
@Configuration
表明当前类是配置类,替换applicationContext.xml
 */