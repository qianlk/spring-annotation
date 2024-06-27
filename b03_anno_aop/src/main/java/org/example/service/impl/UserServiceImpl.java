package org.example.service.impl;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("userService")
//public final class UserServiceImpl implements UserService {
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("执行了保存用户" + user);
    }

    @Override
    public void saveBatchUser(List<User> users) {
        UserService proxyUserService = (UserService) AopContext.currentProxy();
        for (User user : users) {
            proxyUserService.saveUser(user);
        }
    }
}
