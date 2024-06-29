package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Qianlk
 */
@Configuration
@ComponentScan("org.example")
@Import({JdbcConfig.class, TransactionManagerConfig.class})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement  // 开启spring事务注解的支持
public class SpringConfig {
}
