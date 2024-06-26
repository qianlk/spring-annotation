package org.example.a06_dependon.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qlk
 */
class SpringConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        context.start();
    }

}