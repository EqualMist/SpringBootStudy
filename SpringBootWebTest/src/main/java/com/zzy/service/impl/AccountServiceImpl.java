package com.zzy.service.impl;

import com.zzy.entity.Account;
import com.zzy.repo.AccountRepository;
import com.zzy.service.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountRepository accountRepository;

    @Override
    public void createAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(new BCryptPasswordEncoder().encode(password));
        accountRepository.save(account);
    }
}
