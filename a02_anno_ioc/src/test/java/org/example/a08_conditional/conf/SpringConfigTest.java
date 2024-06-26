package org.example.a08_conditional.conf;


import org.example.a08_conditional.conf.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author qlk
 */
class SpringConfigTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);

        ac.close();
    }

}