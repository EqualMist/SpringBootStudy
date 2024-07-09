package com.zzy.mapper;

import com.zzy.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@CacheNamespace(implementation = MybatisRedisCache.class)
@Mapper
public interface CacheMapper {

    @Select("SELECT name FROM student WHERE sid = 3")
    String getStudentName();

}
