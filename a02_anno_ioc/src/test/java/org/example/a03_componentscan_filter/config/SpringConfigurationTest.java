package org.example.a03_componentscan_filter.config;


import org.example.a03_componentscan_filter.service.DistrictPercentage;
import org.example.a03_componentscan_filter.service.DistrictPerformance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qlk
 */
class SpringConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        DistrictPercentage districtPercentage = ctx.getBean("districtPercentage", DistrictPercentage.class);
        districtPercentage.salePercentage("SUV");

        DistrictPerformance districtPerformance = ctx.getBean("districtPerformance", DistrictPerformance.class);
        districtPerformance.calcPerformance("SUV");
    }

}