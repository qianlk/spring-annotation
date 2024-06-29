package org.example.a04_import.config;

import org.example.a04_import.custom.CstImportBeanDefinitionRegistrar;
import org.example.a04_import.custom.CstImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author qlk
 */
@Configuration
//@ComponentScan("org.example.a04_import")
//@ComponentScan("org.example.a04_import.service.impl")
//@Import({JdbcConfig.class, CstImportSelector.class})
//@Import(CstImportSelector.class)
@Import(CstImportBeanDefinitionRegistrar.class)
public class SpringConfiguration {
}

/*
该注解是写在类上的，通常都是和注解驱动的配置类一起使用的。其作用是引入其他的配置类。
使用了此注解之后，可以使我们的注解驱动开发和早期xml配置一样，分别配置不同的内容，使配置更加清晰。
同时指定了此注解之后，被引入的类上可以不再使用@Configuration,@Component等注解。

value属性
    Allows for importing @Configuration classes,
    ImportSelector and ImportBeanDefinitionRegistrar implementations,
    as well as regular component classes
 */