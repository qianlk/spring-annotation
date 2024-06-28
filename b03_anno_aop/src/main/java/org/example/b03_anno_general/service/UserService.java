package org.example.b03_anno_general.service;


import org.example.b03_anno_general.domain.User;

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
    void saveUser(User user, String id);

    User findById(String id);
}
