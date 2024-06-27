package org.example.b02_aspect.service;


import org.example.b02_aspect.domain.User;

import java.util.List;

/**
 * 业务层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface UserService {

    /**
     * 模拟保存用户
     * @param user
     */
    void saveUser(User user);

    void saveBatchUser(List<User> users);
}
