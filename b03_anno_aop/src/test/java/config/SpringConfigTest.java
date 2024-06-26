package config;

import org.example.b01_enable_aspectj_autoproxy.config.SpringConfig;
import org.example.b01_enable_aspectj_autoproxy.domain.User;
import org.example.b01_enable_aspectj_autoproxy.service.UserService;
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

        List<User> users = new ArrayList<>();
        users.add(user);
        userService.saveBatchUser(users);
    }

}