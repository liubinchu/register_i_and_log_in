package com.htsc.hittraining.web.register_i_and_log_in.Dao;

import Entity.User;
import org.apache.ibatis.annotations.*;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-01 22:36
 **/
@Mapper
public interface UserDao {
    @Select("SELECT * FROM web_service WHERE UserName = #{UserName}")
    User findByName(@Param("UserName") String UserName);

    @Select("SELECT * FROM web_service WHERE UserId = #{UserId}")
    User findById(@Param("UserId") int UserId);

    @Insert("INSERT INTO web_service(UserName, password) VALUES(#{UserName}, #{password})")
    int insert(@Param("UserName") String name, @Param("password") String password);

    @Results({
            @Result(property = "UserName", column = "UserName"),
            @Result(property = "password", column = "password")
    })
    @Select("SELECT UserName, password FROM web_service")
    List<User> findAll();
}
