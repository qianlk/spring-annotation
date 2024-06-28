package org.example.b03_anno_general.service.impl;

import org.example.b03_anno_general.domain.User;
import org.example.b03_anno_general.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user, String id) {
//        int i = 1 / 0;
        System.out.println("执行了保存用户" + user + "," + id);
    }

    @Override
    public User findById(String id) {
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        user.setNickname("泰斯特");
        int i = 1 / 0;
        return user;
    }
}
