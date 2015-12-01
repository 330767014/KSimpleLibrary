package com.kot32.ksimpleframeworklibrary.model;

import com.kot32.ksimplelibrary.model.domain.BaseUserModel;

/**
 * Created by kot32 on 15/11/9.
 */
public class Student extends BaseUserModel {
    private int id;
    private String username;
    private String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
