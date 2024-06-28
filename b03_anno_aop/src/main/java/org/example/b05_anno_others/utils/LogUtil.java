package org.example.b05_anno_others.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.example.b05_anno_others.domain.User;
import org.example.b05_anno_others.extensions.ValidateExtensionService;
import org.example.b05_anno_others.extensions.imo.ValidateExtensionServiceImpl;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
@Aspect  // 表明当前类是一个切面类
public class LogUtil {

    /**
     * 注解@DeclareParents, 让目标类具有当前声明接口中的方法, 使用的是动态代理(创建动态代理时多实现一个方法)
     * value用于指定目标类, + 表达接口的所有实现类
     * defaultImpl用于指定声明接口的默认实现类
     * <p/>
     * 触发方法时,可以有多种方法:
     * 1. 编码时触发
     * 2. 切面类通知方法触发
     *
     */
    @DeclareParents(value = "org.example.b05_anno_others.service.UserService+", defaultImpl = ValidateExtensionServiceImpl.class)
    private ValidateExtensionService validateExtensionService;

    @Before(value = "execution(* org.example.b05_anno_others.service.impl.*.*(..)) && args(user) && this(validateExtensionService)", argNames = "validateExtensionService,user")
    public void before(ValidateExtensionService validateExtensionService, User user) {
        boolean checked = validateExtensionService.checkUser(user);
        if (checked) {
            System.out.println("执行前置通知");
        } else {
            // 阻止程序继续执行
            throw new IllegalArgumentException("username illegal");
        }

    }

}
