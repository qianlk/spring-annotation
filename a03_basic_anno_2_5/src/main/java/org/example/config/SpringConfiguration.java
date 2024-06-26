package org.example.config;

import org.example.factory.YamlPropertyFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qlk
 */
@Configuration
@ComponentScan("org.example")
@Import(JdbcConfig.class)
@PropertySource(value = "classpath:jdbc.yml", factory = YamlPropertyFactory.class, encoding = "UTF-8")
public class SpringConfiguration {
}
