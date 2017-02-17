package com.boot.pojo;

/**
 * Created by w-fy on 2017/1/11.
 */
public class Record {
    private Integer id;
    private String name;
    private String data;
    private Integer userid;
    private String username;
    private String comments;
    private String fileUrl;

    public Record() {
    }

    public Record(Integer id, String name, String data, Integer userid, String username, String comments,String fileUrl) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.userid = userid;
        this.username = username;
        this.comments = comments;
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
