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
