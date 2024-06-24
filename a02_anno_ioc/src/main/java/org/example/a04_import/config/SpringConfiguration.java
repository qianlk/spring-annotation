package org.example.a04_import.config;

import org.example.a04_import.custom.CstImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author qlk
 */
@Configuration
@ComponentScan("org.example.a04_import")
//@ComponentScan("org.example.a04_import.service.impl")
@Import({JdbcConfig.class, CstImportSelector.class})
public class SpringConfiguration {
}
