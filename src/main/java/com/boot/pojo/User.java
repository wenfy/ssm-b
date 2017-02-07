package com.boot.pojo;

import com.boot.utils.Values;

/**
 * Created by w-fy on 2017/1/23.
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer status;
    private String statusname;

    public User() {
    }

    public User(Integer id, String name, String password, Integer status, String statusname) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
        this.statusname = statusname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        this.statusname= Values.shenfen[status];
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }
}

