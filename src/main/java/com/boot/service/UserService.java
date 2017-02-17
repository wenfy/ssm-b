package com.boot.service;

import com.boot.pojo.User;

import java.util.List;

/**
 * Created by w-fy on 2017/1/24.
 */
public interface UserService {
     List<User> getAll();
     User getUser(User user);
     void insert(User user);
     void update(int id);
    void delete(int id);
    List getAllName();
     User getById(int id);
}
