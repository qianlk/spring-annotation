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

/*
@PropertySource
用于指定读取资源文件的位置。注意，它不仅支持properties，也支持xml文件，并且通过YAML解析器，配合自定义PropertySourceFactory实现解析yml配置文件

    name:
		指定资源的名称。如果没有指定，将根据基础资源描述生成。
	value:
		指定资源的位置。可以是类路径，也可以是文件路径。
	ignoreResourceNotFound:
		指定是否忽略资源文件有没有，默认是false,也就是说当资源文件不存在时spring启动将会报错。
	encoding:
		指定解析资源文件使用的字符集。当有中文的时候，需要指定中文的字符集。
	factory:
		指定读取对应资源文件的工厂类，默认的是PropertySourceFactory。
 */