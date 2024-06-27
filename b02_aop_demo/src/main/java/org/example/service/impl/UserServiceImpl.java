package org.example.service.impl;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("执行了保存用户" + user);
    }
}
