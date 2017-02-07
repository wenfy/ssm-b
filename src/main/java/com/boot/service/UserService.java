package com.boot.service;

import com.boot.pojo.User;

import java.util.List;

/**
 * Created by w-fy on 2017/1/24.
 */
public interface UserService {
    public List<User> getAll();
    public  User getUser(User user);
    public void insert(User user);
    public void update(int id);
    public void delete(int id);
    public List getAllName();
    public User getById(int id);
}
