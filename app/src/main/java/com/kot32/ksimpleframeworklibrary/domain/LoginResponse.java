package com.kot32.ksimpleframeworklibrary.domain;

import com.kot32.ksimpleframeworklibrary.model.Student;
import com.kot32.ksimplelibrary.model.response.BaseResponse;

/**
 * Created by kot32 on 15/11/15.
 */
public class LoginResponse extends BaseResponse {

    private int responseCode;

    private String token;
    private Student student;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
