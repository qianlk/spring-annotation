package org.example.a01_bean.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author qlk
 */
@Configuration
public class SpringConfiguration {

    // autowireCandidate表示是否可以自动装配

//    @Bean(name = "dataSource", autowireCandidate = false)
    @Bean(name = "dataSource", autowireCandidate = true)
    public DataSource createDataSource() {
        return new DriverManagerDataSource();
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

/*
@Bean

	name:
		用于指定存入spring容器中bean的标识。支持指定多个标识。当不指定该属性时，默认值是当前方法的名称。
	value:
		此属性是在4.3.3版本之后加入的。它和name属性的作用是一样的。
	autowireCandidate:
		用于指定是否支持自动按类型注入到其他bean中。只影响@Autowired注解的使用。不影响@Resource注解注入。默认值为true，意为允许使用自动按类型注入。
	initMethod:
		用于指定初始化方法。(通常不使用, 一般在使用@Bean的方法中可以编码实现初始化内容,例如加载数据源配置信息)
	destroyMethod:
		用于指定销毁方法。

	通常情况下，在基于注解的配置中，我们用于把一个类存入spring的ioc容器中，首先考虑的是使用@Component以及他的衍生注解。
	但是如果遇到要存入容器的Bean对象不是我们写的类，此时无法在类上添加@Component注解，这时就需要此注解了。

1. @Bean不指定名称时, 默认以方法名作为beanName
2. 当@Bean修饰的方法有重载时,选择到后面添加的方法
 */
