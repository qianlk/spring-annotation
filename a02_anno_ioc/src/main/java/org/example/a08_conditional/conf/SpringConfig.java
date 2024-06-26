package org.example.a08_conditional.conf;

import org.example.a08_conditional.config.JdbcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qlk
 */
@Configuration
@Import(JdbcConfig.class)
@PropertySource({"classpath:jdbc.properties", "classpath:linux.properties"})
public class SpringConfig {
}
