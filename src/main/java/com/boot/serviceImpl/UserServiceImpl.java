package com.boot.serviceImpl;

import com.boot.mapper.UserMapper;
import com.boot.pojo.User;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by w-fy on 2017/1/24.
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserMapper userMapper;

    public List<User> getAll() {

        return userMapper.getAll();
    }

    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void update(int id) {
        userMapper.update(id);

    }

    public void delete(int id) {
        userMapper.delete(id);

    }

    public List getAllName() {
        return   userMapper.getAllName();
    }

    public User getById(int id) {
        return userMapper.getById(id);
    }
}
