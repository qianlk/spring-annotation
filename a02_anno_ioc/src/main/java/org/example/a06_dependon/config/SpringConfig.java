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

/*
@DependsOn
用于指定某个类的创建依赖的bean对象先创建。spring中没有特定bean的加载顺序，使用此注解则可指定bean的加载顺序。
(在基于注解配置中，是按照类中方法的书写顺序决定的)

在观察者模式中，分为事件，事件源和监听器。
一般情况下，我们的监听器负责监听事件源，当事件源触发了事件之后，监听器就要捕获，并且做出相应的处理。
以此为前提，我们肯定希望监听器的创建时间在事件源之前，此时就可以使用此注解。
 */
