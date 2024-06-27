package org.example.dao;

import org.example.domain.Account;

import java.util.List;

/**
 * @author qlk
 */
public interface AccountDao {

    void save(Account account);

    void update(Account account);

    void delete(Integer id);

    Account findById(Integer id);

    List<Account> findAll();

    Account findByName(String sourceName);
}
