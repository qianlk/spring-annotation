package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;

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

    @Bean("jdbcTemplate1")
    @Primary
    public JdbcTemplate createJdbcTemplateOne(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("jdbcTemplate2")
    public JdbcTemplate createJdbcTemplateTwo(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 实现connection绑定线程
     * @param dataSource
     * @return
     */
    @Bean("connection")
    public Connection getConnection(DataSource dataSource){
        System.out.println(TransactionSynchronizationManager.isSynchronizationActive());
        //1.初始化事务同步管理器
        TransactionSynchronizationManager.initSynchronization();
        //2.使用spring的数据源工具类获取当前线程的连接
        Connection connection = DataSourceUtils.getConnection(dataSource);
        //3.返回
        return connection;
    }
}
