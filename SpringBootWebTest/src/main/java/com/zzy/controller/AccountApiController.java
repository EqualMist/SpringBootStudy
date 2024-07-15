package com.zzy.controller;

import com.zzy.entity.Account;
import com.zzy.entity.resp.RestBean;
import com.zzy.repo.AccountRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/static/api/user")
public class AccountApiController {

    @Resource
    AccountRepository accountRepository;

    @GetMapping("/getUserInfo")
    public RestBean<Account> getUserInfo() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Account account = accountRepository.findAccountByUsername(securityContext.getAuthentication().getName());
        account.setPassword(null);
        return new RestBean<>(200, "用户信息请求成功", account);
    }
}
