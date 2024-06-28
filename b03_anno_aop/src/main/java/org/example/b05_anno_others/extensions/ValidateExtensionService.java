package org.example.b05_anno_others.extensions;


import org.example.b05_anno_others.domain.User;

/**
 * 拓展 用户service保存方法验证的接口
 *
 * @author Qianlk
 */
public interface ValidateExtensionService {

    boolean checkUser(User user);
}
