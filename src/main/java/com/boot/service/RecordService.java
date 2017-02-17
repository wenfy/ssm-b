package com.boot.service;

import com.boot.pojo.Record;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
public interface RecordService {
     List<Record> getAll();
     List<Record> getAllByName(String name);
     List<Record> getAllById(int id);
    void insert(Record r);
     void update(Record r);
     void delete(int id);
     Record getById(int id);
     String getCommentsById(int id);
     String getFileUrlById(int id);
    List<String> getFileUrl(String fileUrl);
}
