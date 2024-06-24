package org.example.a02_componentscan.service.impl;

import org.example.a02_componentscan.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author qlk
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("用户保存");
    }
}
