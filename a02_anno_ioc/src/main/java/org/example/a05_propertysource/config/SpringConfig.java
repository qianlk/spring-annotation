package org.example.a05_propertysource.config;

import org.example.a05_propertysource.cst.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qlk
 */
@Configuration
@Import(JdbcConfig.class)
//@PropertySource("classpath:jdbc.properties")
//@PropertySource("file:///D:/program/spring/spring-annotation/a02_anno_ioc/src/main/resources/jdbc.properties")
@PropertySource(value = "classpath:jdbc.yml", encoding = "UTF-8", factory = YamlPropertySourceFactory.class)
public class SpringConfig {
}
