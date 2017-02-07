package com.boot.service;

import com.boot.pojo.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
public interface RecordService {
    public List<Record> getAll();
    public List<Record> getAllByName(String name);
    public List<Record> getAllById(int id);
    public void insert(Record r);
    public void update(Record r);
    public void delete(int id);
    public Record getById(int id);
    public String getCommentsById(int id);
}
