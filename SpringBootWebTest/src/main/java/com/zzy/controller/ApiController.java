package com.zzy.controller;

import com.zzy.entity.RestBean;
import com.zzy.service.VerifyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/auth")
public class ApiController {

    @Resource
    VerifyService verifyService;

    @RequestMapping("/verify-code")
    public RestBean verifyCode(@RequestParam("email") String email) {
        try {
            verifyService.sendVerifyCode(email);
        } catch (Exception e) {
            return new RestBean(500, "验证码发送失败");
        }
        return new RestBean(200, "验证码发送成功");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RestBean register(@RequestParam("username") String username ,
                             @RequestParam("email") String email,
                             @RequestParam("verify") String verify,
                             @RequestParam("password") String password) {
        boolean resultBoolean = verifyService.doVerifyAndRegister(username, email, verify, password);
        if (resultBoolean) {
            return new RestBean(200, "注册成功");
        } else {
            return new RestBean(500, "注册失败");
        }
    }

}
