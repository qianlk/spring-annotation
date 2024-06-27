package org.example.factory;

import org.example.service.AccountService;
import org.example.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于生成service代理对象的工厂
 * 实现:
 *      对AccountService进行代理创建,并加入事务
 * @author qlk
 */
@Component
public class ProxyServiceFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    @Bean("proxyAccountService")
    public AccountService getProxyAccountService() {
        // 1.创建代理对象
        AccountService proxyAccountService = (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 1. 定义返回值
                        Object rtValue = null;
                        try {
                            transactionManager.begin();
                            // 2.执行被代理对象的方法
                            rtValue = method.invoke(accountService, args);
                            transactionManager.commit();
                        } catch (Exception e) {
                            transactionManager.rollback();
                        } finally {
                            transactionManager.close();
                        }
                        return rtValue;
                    }
                }
        );
        return proxyAccountService;
    }
}
