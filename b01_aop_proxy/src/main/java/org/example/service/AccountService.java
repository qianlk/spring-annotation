package org.example.service;

import org.example.domain.Account;

import java.util.List;

/**
 * @author qlk
 */
public interface AccountService {
    void save(Account account);

    void update(Account account);

    void delete(Integer id);

    Account findById(Integer id);

    List<Account> findAll();

    void transfer(String sourceName, String targetName, Double money);
}
