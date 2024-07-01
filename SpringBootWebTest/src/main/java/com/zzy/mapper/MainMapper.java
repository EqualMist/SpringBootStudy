package com.zzy.mapper;

import com.zzy.entity.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MainMapper {

    @Select("SELECT * FROM users WHERE name = #{name}")
    UserData getUserByName(String name);

}
