package org.example.config;

import org.example.domain.Account;
import org.example.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author qlk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringConfigurationTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService accountService;

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("spring annotation");
        account.setMoney(1111d);
        accountService.save(account);
    }

    @Test
    public void testUpdate() {
        Account account = accountService.findById(2);
        account.setName("test222");
        account.setMoney(2222d);
        accountService.update(account);
    }

    @Test
    public void testDelete() {
        accountService.delete(1);
    }

    @Test
    public void testFindOne() {
        accountService.findById(2);
    }

    @Test
    public void testFindAll() {
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb", 100d);
    }
}