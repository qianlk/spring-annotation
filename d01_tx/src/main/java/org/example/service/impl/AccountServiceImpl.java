package org.example.service.impl;

import org.example.dao.AccountDao;
import org.example.domain.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qianlk
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String sourceName, String targetName, Double money) {
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.update(source);
        // 模拟异常
        int i = 1 / 0;
        accountDao.update(target);
    }
}
