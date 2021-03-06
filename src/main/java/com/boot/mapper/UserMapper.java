package com.boot.mapper;

import com.boot.pojo.User;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by w-fy on 2017/1/23.
 */
@Mapper
public interface UserMapper {
    @Select("select * from User")
     List<User> getAll();

    @Select("select name from User where name=#{name}")
     User getUser(User user);

    @Insert("insert into User(name,password,status) values(#{name},#{password},#{status})")
    void insert(User user);

    @Update("update User set password=#{password} where id=#{id}")
     void update(int id);

    @Delete("delete from  User where id=#{id}")
     void delete(int id);

    @Select("select name from User")
     List getAllName();

    @Select("select * from User where id=#{id}")
     User getById(int id);

}
