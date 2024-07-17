package com.zzy.controller;

import com.zzy.entity.resp.RestBean;
import com.zzy.service.AccountService;
import com.zzy.service.VerifyService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "账户验证接口", description = "包括用户登录、注册、验证码请求等操作。")
@RestController
@RequestMapping("/static/api/auth")
public class AuthApiController {

    @Resource
    VerifyService verifyService;
    @Resource
    AccountService accountService;

    @ApiResponses({
            @ApiResponse(code = 200, message = "邮件发送成功"),
            @ApiResponse(code = 500, message = "邮件发送失败")   //不同返回状态码描述
    })
    @ApiOperation("请求邮件验证码")
    @GetMapping("/verify-code")
    public RestBean<Void> verifyCode(@ApiParam("邮箱地址") @RequestParam("email") String email) {
        try {
            verifyService.sendVerifyCode(email);
        } catch (Exception e) {
            return new RestBean<>(500, "验证码发送失败");
        }
        return new RestBean<>(200, "验证码发送成功");
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "注册成功"),
            @ApiResponse(code = 500, message = "注册失败")   //不同返回状态码描述
    })
    @PostMapping("/register")
    public RestBean<Void> register(@ApiParam("用户名") @RequestParam("username") String username ,
                                   @ApiParam("邮箱地址") @RequestParam("email") String email,
                                   @ApiParam("验证码") @RequestParam("verify") String verify,
                                   @ApiParam("密码") @RequestParam("password") String password) {
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
