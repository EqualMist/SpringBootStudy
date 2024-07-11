package com.zzy;

import com.zzy.entity.Account;
import com.zzy.mapper.CacheMapper;
import com.zzy.repo.AccountRepository;
import com.zzy.service.impl.RedisService;
import com.zzy.service.impl.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBootWebTestApplicationTests {

    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    RedisService redisService;
    @Resource
    CacheMapper cacheMapper;
    @Resource
    JavaMailSender javaAutoMailSender;
    @Resource
    AccountRepository accountRepository;



    @Test
    void contextLoads() {
//        redisService.test();

//        cacheMapper.getStudentName();
//        cacheMapper.getStudentName();
//        cacheMapper.getStudentName();

        //SimpleMailMessage是一个比较简易的邮件封装，支持设置一些比较简单内容
//        SimpleMailMessage message = new SimpleMailMessage();
//        //设置邮件标题
//        message.setSubject("Java发送邮件测试");
//        //设置邮件内容
//        message.setText("邮件内容内容测试");
//        //设置邮件发送给谁，可以多个，这里就发给你的QQ邮箱
//        message.setTo("myhazelnut@163.com");
//        //邮件发送者，这里要与配置文件中的保持一致
//        message.setFrom("myhazelnut@163.com");
//        //OK，万事俱备只欠发送
//        javaAutoMailSender.send(message);

        //JPA
//        System.out.println(accountRepository.findById(1));

//        Account account = new Account();
//        account.setUsername("小红");
//        account.setPassword("123456");
//        account.setRole("user");
//        account = accountRepository.save(account);
//        System.out.println("插入的数据为：" +account);

//        accountRepository.deleteById(3);

        accountRepository.findAll(PageRequest.of(1, 1)).forEach(System.out::println);
    }

    @Test
    void testFindAccount() {
//        Account account = accountRepository.findAccountByUsername("Acheron");

//        Account account = accountRepository.findAccountByUsernameLike("%ly%");

        Account account = accountRepository.findAccountByIdAndUsername(2,"Acheron");

        boolean flag = accountRepository.existsAccountByUsername("Acheron");
        System.out.println(flag);
    }

}
