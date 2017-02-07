package com.boot.serviceImpl;

import com.boot.mapper.RecordMapper;
import com.boot.pojo.Record;
import com.boot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Service
public class RecordServiceImpl implements RecordService{
   @Autowired
   RecordMapper recordMapper;

    public List<Record> getAll() {
        return recordMapper.getAll();
    }

    public List<Record> getAllByName(String name) {
        return recordMapper.getAllByName(name);
    }

    public List<Record> getAllById(int id) {
        return recordMapper.getAllById(id);
    }

    public void insert(Record r) {
        recordMapper.insert(r);
    }

    public void update(Record r) {
        recordMapper.update(r);

    }

    public void delete(int id) {
        recordMapper.delete(id);

    }

    public Record getById(int id) {
        return recordMapper.getById(id);
    }

    public String getCommentsById(int id) {
        return recordMapper.getCommentsById(id);
    }


}
