package com.zzy.service.impl;

import com.zzy.mapper.MainMapper;
import com.zzy.service.VerifyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class VerifyServiceImpl implements VerifyService {

    @Value("${spring.mail.username}")
    String fromEmail;

    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    JavaMailSender mailSender;
    @Resource
    MainMapper  mainMapper;

    @Override
    public void sendVerifyCode(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("欢迎注册网站");
        // 生成验证码
        Random random = new Random();
        int code = random.nextInt(899999) + 100000;
        stringRedisTemplate.opsForValue().set("verify:email:" + email, code + "", 10, TimeUnit.MINUTES);
        message.setText("您的验证码为："+ code + "。10分钟后失效，请及时完成验证。如果不是本人操作，请忽略。");
        message.setTo(email);
        message.setFrom(fromEmail);
        // 发送邮件
        mailSender.send(message);
    }

    @Override
    public boolean doVerifyAndRegister(String username, String email, String verify, String password) {
        // 获取Redis中的邮箱
        String verifyCode = stringRedisTemplate.opsForValue().get("verify:email:" + email);
        if (verifyCode == null) {
            return false;
        }
        return true;
    }
}
