package com.boot.mapper;

import com.boot.pojo.Record;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Mapper
public interface RecordMapper {
    @Select("select Record.*,User.name username from Record inner join User on Record.userid=user.id")
     List<Record> getAll();

   @Select("select Record.*,User.name username from User inner join Record on user.id=Record.userid where User.name=#{name} ")
     List<Record> getAllByName(String name);

    @Select("select Record.*,User.id ui from Record inner join User on Record.userid=user.id and userid=#{id}")
     List<Record> getAllById(int id);

    @Insert("Insert into Record(name,data,userid,comments,fileUrl) values(#{name},#{data},#{userid},#{comments},#{fileUrl})" )
     void insert(Record r);

    @Update("update Record set name=#{name},data=#{data},comments=#{comments},fileUrl=#{fileUrl}  where id=#{id}")
     void update(Record r);

    @Delete("delete from Record where id=#{id} ")
     void delete(int id);

    @Select("select * from Record where id=#{id} ")
     Record getById(int id);

    @Select("select comments from Record where id=#{id}")
     String getCommentsById(int id);

    @Select("select fileUrl from Record where id=#{id}")
    String getFileUrlById(int id);

    @Select("select fileUrl from Record where fileUrl like '%${_parameter}%'")
    List<String> getFileUrl(String fileUrl);
}
