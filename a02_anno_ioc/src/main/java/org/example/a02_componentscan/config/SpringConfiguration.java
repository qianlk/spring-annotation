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
        excludeFilters = @ComponentScan.Filter(value = Service.class))
public class SpringConfiguration {
}
