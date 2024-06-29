package org.example.a02_componentscan.config;

import org.example.a02_componentscan.cst.CstBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author qlk
 */
@Configuration
//    @Component

//@ComponentScan(basePackageClasses = UserService.class)
//@ComponentScan(basePackages = {"org.example.componentscan"}, resourcePattern = "*/*.class")  // 只扫描当前包及其下一层包的类
//@ComponentScan(basePackages = {"org.example.componentscan"}, nameGenerator = CstBeanNameGenerator.class, resourcePattern = "**/*.class",
//        includeFilters = @ComponentScan.Filter(value = Service.class))

@ComponentScan(basePackages = {"org.example"}, nameGenerator = CstBeanNameGenerator.class, resourcePattern = "**/*.class",
        excludeFilters = @ComponentScan.Filter(value = Service.class), useDefaultFilters = true)
public class SpringConfiguration {
}

/*
@ComponentScan: 指定创建容器时要扫描的包或者类,支持定义扫描规则,支持过滤规则,支持bean的命名规则

    value:
		用于指定要扫描的包。当指定了包的名称之后，spring会扫描指定的包及其子包下的所有类。
	basePackages:
		它和value作用是一样的。
	basePackageClasses:
		指定具体要扫描的类的字节码,以及字节码所在的包及其子包。
	nameGenrator:
		指定扫描bean对象存入容器时的命名规则。详情请参考第五章第4小节的BeanNameGenerator及其实现类。(源码阅读,实现自定义的bean名称生成器CstBeanNameGenerator.java)
	scopeResolver:
		用于处理并转换检测到的Bean的作用范围。
	soperdProxy:
		用于指定bean生成时的代理方式。默认是Default，则不使用代理。详情请参考第五章第5小节ScopedProxyMode枚举。
	resourcePattern:
		用于指定符合组件检测条件的类文件，默认是包扫描下的
        useDefaultFilters:
        是否对带有@Component @Repository @Service @Controller注解的类开启检测,默认是开启的。
        includeFilters:
        自定义组件扫描的过滤规则，用以扫描组件。(注意,include没有任何排除的意思, 指定include,不会排除其他的类型)
        FilterType有5种类型：
        ANNOTATION, 注解类型 默认
        ASSIGNABLE_TYPE,指定固定类
        ASPECTJ， ASPECTJ类型
                REGEX,正则表达式
        CUSTOM,自定义类型
                详细用法请参考第五章第6小节自定义组件扫描过滤规则
        excludeFilters:
        自定义组件扫描的排除规则。
        lazyInit:
        组件扫描时是否采用懒加载 ，默认不开启。
 */