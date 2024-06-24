package org.example.a02_componentscan.service.impl;

import org.example.a02_componentscan.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author qlk
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void deleteUser() {
        System.out.println("实现用户删除");
    }
}
