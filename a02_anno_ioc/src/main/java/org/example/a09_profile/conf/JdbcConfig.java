package org.example.a09_profile.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

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
    @Profile("dev")
    public DruidDataSource createDevDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 设置最大活动连接数
        dataSource.setMaxActive(5);
        return dataSource;
    }

    @Bean("dataSource")
    @Profile("test")
    public DruidDataSource createTestDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 设置最大活动连接数
        dataSource.setMaxActive(50);
        return dataSource;
    }

    @Bean("dataSource")
    @Profile("prod")
    public DruidDataSource createProdDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 设置最大活动连接数
        dataSource.setMaxActive(150);
        return dataSource;
    }
}
