package com.zzy.service.impl;

import com.zzy.entity.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource
    RedisTemplate<Object, Object> redisTemplate;

    @PostConstruct
    public void init() {
        redisTemplate.setEnableTransactionSupport(true);  // 需要开启事务
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
    }

    @Transactional
    public void test () {
        redisTemplate.multi();
        Student student = new Student();
        student.setSid(1).setName("Elysia").setSex("女");
        redisTemplate.opsForValue().set("student", student);
        redisTemplate.exec();
    }
}
