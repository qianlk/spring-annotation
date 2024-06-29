package org.example.dao;

import org.example.domain.Account;

/**
 * @author Qianlk
 */
public interface AccountDao {

    void update(Account account);

    Account findByName(String name);
}
