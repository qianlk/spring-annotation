package org.example.a03_componentscan_filter.config;

import org.example.a03_componentscan_filter.typefilter.DistrictTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 模拟不同销售区域指定不同的实现方法
 * @author qlk
 */
@Configuration
@ComponentScan(
        basePackages = "org.example.a03_componentscan_filter.service",
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = DistrictTypeFilter.class))
public class SpringConfiguration {
}
