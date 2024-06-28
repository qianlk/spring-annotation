package org.example.b05_anno_others.service;


import org.example.b05_anno_others.domain.User;
import org.springframework.context.annotation.Description;

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
    @Description("保存用户")
    void saveUser(User user);

    @Description("根据id查询")
    User findById(String id);

    @Description("根据id更新")
    void updateUser(User user);

    @Description("根据id删除")
    void deleteUser(String id);

    @Description("查询所有")
    List<User> findAll();
}
