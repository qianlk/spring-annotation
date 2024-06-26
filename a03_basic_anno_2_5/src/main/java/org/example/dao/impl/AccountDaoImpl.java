package org.example.dao.impl;

import jdk.jfr.Name;
import org.example.dao.AccountDao;
import org.example.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author qlk
 */
@Repository
public class AccountDaoImpl implements AccountDao {

//    @Autowired
//    @Qualifier("jdbcTemplate2")
//    @Named("jdbcTemplate2")
//    private JdbcTemplate jdbcTemplate;

    // jsr250
//    @Resource(name = "jdbcTemplate2", type = JdbcTemplate.class)
//    private JdbcTemplate jdbcTemplate;

    // jsr330
    @Inject
//    @Named("jdbcTemplate2")
//    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Account account) {
        jdbcTemplate.update("insert into account(name, money) values (?,?)", account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set name=?, money=?", account.getName(), account.getMoney());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from account where id = ?", id);
    }

    @Override
    public Account findById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }
}
