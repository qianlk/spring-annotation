package org.example.a07_lazy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author qlk
 */
@Configuration
@ComponentScan(value = {"org.example.a07_lazy.utils"})
public class SpringConfig {
}
