package org.example.b04_anno_around.config;

import org.example.b04_anno_around.domain.User;
import org.example.b04_anno_around.service.UserService;
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
        user.setNickname("泰斯特");

        userService.saveUser(user);
        System.out.println("===========");
        userService.findById("1");
        System.out.println("===========");
        userService.updateUser(user);
        System.out.println("===========");
        userService.deleteUser("1");
        System.out.println("===========");
        for (User u : userService.findAll()) {
            System.out.println(u);
        }

    }

}