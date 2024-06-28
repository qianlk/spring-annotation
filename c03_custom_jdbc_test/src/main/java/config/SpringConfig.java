package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Qianlk
 */
@Configuration
@ComponentScan("org.example")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}
