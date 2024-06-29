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


/*
@Conditional(LinuxCondition.class)
它的作用是根据条件选择注入的bean对象

value:
		用于提供一个Condition接口的实现类，实现类中需要编写具体代码实现注入的条件。
 */