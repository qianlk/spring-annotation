package org.example.a04_import.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author qlk
 */
public class JdbcConfig {


    @Bean("dataSource")
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.137.11:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        dataSource.setUsername("dev");
        dataSource.setPassword("?7h3{<+2{47!..H");
        return dataSource;
    }
}
