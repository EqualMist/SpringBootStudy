package com.zzy.controller;

import com.zzy.entity.resp.RestBean;
import com.zzy.service.AccountService;
import com.zzy.service.VerifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/static/api/auth")
public class AuthApiController {

    @Resource
    VerifyService verifyService;
    @Resource
    AccountService accountService;

    @GetMapping("/verify-code")
    public RestBean<Void> verifyCode(@RequestParam("email") String email) {
        try {
            verifyService.sendVerifyCode(email);
        } catch (Exception e) {
            return new RestBean<>(500, "验证码发送失败");
        }
        return new RestBean<>(200, "验证码发送成功");
    }

    @PostMapping("/register")
    public RestBean<Void> register(@RequestParam("username") String username ,
                             @RequestParam("email") String email,
                             @RequestParam("verify") String verify,
                             @RequestParam("password") String password) {
        boolean resultBoolean = verifyService.doVerifyAndRegister(username, email, verify, password);
        accountService.createAccount(username, password);
        if (resultBoolean) {
            return new RestBean<>(200, "注册成功");
        } else {
            return new RestBean<>(500, "注册失败");
        }
    }

    @PostMapping("/login-success")
    public RestBean<Void> loginSuccess() {
        return new RestBean<>(200, "登录成功");
    }

    @GetMapping("/logout-success")
    public RestBean<Void> logoutSuccess() {
        return new RestBean<>(200, "退出成功");
    }

    @PostMapping("/login-failure")
    public RestBean<Void> loginFailure() {
        return new RestBean<>(500, "登录失败");
    }

    @RequestMapping("access-denied")
    public RestBean<Void> accessDenied() {
        return new RestBean<>(401, "未验证，请先登录！");
    }

}
