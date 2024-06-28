package config;

import org.example.domain.Account;
import org.example.jdbc.JdbcTemplate;
import org.example.jdbc.handler.impl.BeanHandler;
import org.example.jdbc.handler.impl.BeanListHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author Qianlk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringConfigTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplate() {
        System.out.println(jdbcTemplate);
    }

    @Test
    public void testSave() {
        jdbcTemplate.update("insert into account(name, money)values(?,?)", "CustomJdbcTemplate", 6789d);
    }

    @Test
    public void testUpdate() {
        jdbcTemplate.update("update account set name=?,money=? where id=?", "testZZZ", 23456d, 2);
    }

    @Test
    public void testDelete() {
        jdbcTemplate.update("delete from account where id = ? ", 7);
    }

    @Test
    public void testFindOne() {
        Account account = (Account) jdbcTemplate.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), 2);
        System.out.println(account);
    }

    @Test
    public void testFindAll() {
        List<Account> accountList = (List<Account>) jdbcTemplate.query("select * from account where money > ?", new BeanListHandler<Account>(Account.class), 999d);
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
}