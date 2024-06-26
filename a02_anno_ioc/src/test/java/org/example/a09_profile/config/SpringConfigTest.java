package org.example.a09_profile.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit注解
 *
 * @author qlk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@ActiveProfiles("prod")
public class SpringConfigTest {

    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void testDataSource() {
        System.out.println(druidDataSource.getMaxActive());
    }
}