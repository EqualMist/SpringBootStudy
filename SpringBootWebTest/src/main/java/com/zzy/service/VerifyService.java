package com.zzy.service;

public interface VerifyService {

    void sendVerifyCode(String email);

    boolean doVerifyAndRegister(String username, String email, String verify, String password);
}
