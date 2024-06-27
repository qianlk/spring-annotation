package org.example.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author qlk
 */
public class JdbcConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        Connection connection = context.getBean("connection", Connection.class);
        System.out.println("connection = " + connection);

    }

}