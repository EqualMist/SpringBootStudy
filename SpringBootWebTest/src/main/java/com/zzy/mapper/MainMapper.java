package com.zzy.mapper;

import com.zzy.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MainMapper {

    @Select("SELECT * FROM users WHERE name = #{name}")
    Account getUserByName(String name);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // 添加后自动返回id信息
    @Insert("INSERT INTO users(name, email, password) VALUES (#{name}, #{email}, #{password})")
    int registerUserWithEmail(Account user);

}
