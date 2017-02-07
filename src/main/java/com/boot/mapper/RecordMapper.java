package com.boot.mapper;

import com.boot.pojo.Record;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Mapper
public interface RecordMapper {
    @Select("select Record.*,User.name username from Record inner join User on Record.userid=user.id")
    public List<Record> getAll();

   @Select("select Record.*,User.name username from User inner join Record on user.id=Record.userid where User.name=#{name} ")
    public List<Record> getAllByName(String name);

    @Select("select Record.*,User.id ui from Record inner join User on Record.userid=user.id and userid=#{id}")
    public List<Record> getAllById(int id);

    @Insert("Insert into Record(name,data,userid,comments) values(#{name},#{data},#{userid},#{comments})" )
    public void insert(Record r);

    @Update("update Record set name=#{name},data=#{data},comments=#{comments} where id=#{id}")
    public void update(Record r);

    @Delete("delete from Record where id=#{id} ")
    public void delete(int id);

    @Select("select * from Record where id=#{id} ")
    public Record getById(int id);

    @Select("select comments from Record where id=#{id}")
    public String getCommentsById(int id);
}
