package org.example.a01_bean.annotations;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qlk
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Bean
public @interface MyBean {
}
