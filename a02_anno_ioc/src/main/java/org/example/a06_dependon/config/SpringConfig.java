package org.example.a06_dependon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 控制bean创建时间的先后顺序
 * <br/>
 * <p>@DependsOn("eventListener")</p>
 *
 * @author qlk
 */
@Configuration
@ComponentScan(value = {"org.example.a06_dependon.event"})
public class SpringConfig {
}
