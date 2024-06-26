package org.example.a08_conditional.config;

import org.example.a08_conditional.condition.LinuxCondition;
import org.example.a08_conditional.condition.WindowsCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author qlk
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    @Conditional(LinuxCondition.class)
    public DataSource createLinuxDataSource(@Value("${linux.driver}") String linuxDriver,
                                       @Value("${linux.url}") String linuxUrl,
                                       @Value("${linux.username}") String linuxUsername,
                                       @Value("${linux.password}") String LinuxPassword) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(linuxDriver);
        dataSource.setUrl(linuxUrl);
        dataSource.setUsername(linuxUsername);
        dataSource.setPassword(LinuxPassword);
        System.out.println("linux URL is :" + url);
        return dataSource;
    }

    @Bean("dataSource")
    @Conditional(WindowsCondition.class)
    public DataSource createWindowsDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println("windows URL is :" + url);
        return dataSource;
    }


}
