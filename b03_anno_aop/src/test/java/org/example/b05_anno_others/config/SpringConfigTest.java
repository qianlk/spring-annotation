package org.example.b05_anno_others.config;


import org.example.b05_anno_others.domain.User;
import org.example.b05_anno_others.extensions.ValidateExtensionService;
import org.example.b05_anno_others.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Qianlk
 */
public class SpringConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        user.setNickname("孙子"); // 泰斯特

        // 1 可以在使用时,强制触发增强的实现类方法
//        ValidateExtensionService validateExtensionService = (ValidateExtensionService) userService;
//        if (validateExtensionService.checkUser(user)) {
//            userService.saveUser(user);
//        }

        // 2. 也可以在切面里触发
        userService.saveUser(user);

    }
}