package org.example.b02_aspect.config;

import org.example.b02_aspect.domain.User;
import org.example.b02_aspect.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qlk
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

//        List<User> users = new ArrayList<>();
//        users.add(user);
//        userService.saveBatchUser(users);
    }

}