package org.example.a02_componentscan.config;

import org.example.a02_componentscan.utils.LogUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qlk
 */
class SpringConfigurationTest {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("org.example.componentscan.config");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

//        UserService userService = ctx.getBean("myuserService", UserService.class);
//        userService.saveUser();
//        AccountService accountService = ctx.getBean(AccountServiceImpl.class);
//        accountService.deleteUser();

        LogUtil logUtil = ctx.getBean("mylogUtil", LogUtil.class);
        logUtil.printLog();

    }

}