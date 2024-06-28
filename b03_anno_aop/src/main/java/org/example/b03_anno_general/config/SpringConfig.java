package org.example.b03_anno_general.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qlk
 */
@Configuration
@ComponentScan("org.example.b03_anno_general")
@EnableAspectJAutoProxy
public class SpringConfig {
}
