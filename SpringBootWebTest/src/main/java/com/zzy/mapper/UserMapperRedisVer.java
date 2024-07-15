package com.zzy.mapper;

import com.zzy.cache.MybatisRedisCache;
import com.zzy.entity.Account;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@CacheNamespace(implementation = MybatisRedisCache.class)
@Mapper
public interface UserMapperRedisVer {

    @Select("SELECT * FROM users WHERE name = #{username}")
    Account getAccountByUsername(String name);
}
