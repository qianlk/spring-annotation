package org.example;

import org.example.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author qlk
 */
public class SpringConfigurationTest {

    public static void main(String[] args) {
        
//        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.config");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        jdbcTemplate.update("insert into account(name,money)values(?,?)","test2",12345);

    }

}