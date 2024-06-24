package org.example.a04_import;

import org.example.a04_import.config.SpringConfiguration;
import org.example.a04_import.service.UserService;
import org.example.a04_import.service.utils.LogUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qlk
 */
class SpringConfigurationTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("org.example.a04_import");
//        Object dataSource = ac.getBean("dataSource", DataSource.class);
//        System.out.println("dataSource = " + dataSource);
//
//        for (String name : ac.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

        UserService userService = ac.getBean("org.example.a04_import.service.impl.UserServiceImpl", UserService.class);
        userService.saveUser();

        // 修改expression的aspectj表达式
        LogUtil log = ac.getBean("org.example.a04_import.service.utils.LogUtil", LogUtil.class);
        log.printLog();

    }

}