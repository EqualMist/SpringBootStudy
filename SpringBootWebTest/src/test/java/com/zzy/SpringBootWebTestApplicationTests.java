package com.zzy;

import com.zzy.mapper.CacheMapper;
import com.zzy.service.impl.RedisService;
import com.zzy.service.impl.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootWebTestApplicationTests {

    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    RedisService redisService;
    @Resource
    CacheMapper cacheMapper;


    @Test
    void contextLoads() {
//        redisService.test();

//        cacheMapper.getStudentName();
//        cacheMapper.getStudentName();
//        cacheMapper.getStudentName();
    }

}
