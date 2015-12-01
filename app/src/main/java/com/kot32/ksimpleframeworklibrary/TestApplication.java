package com.kot32.ksimpleframeworklibrary;

import com.kot32.ksimpleframeworklibrary.domain.LoginResponse;
import com.kot32.ksimpleframeworklibrary.model.Student;
import com.kot32.ksimplelibrary.KSimpleApplication;
import com.kot32.ksimplelibrary.manager.task.LoginTask;
import com.kot32.ksimplelibrary.manager.task.base.NetworkTask;
import com.kot32.ksimplelibrary.model.response.BaseResponse;
import com.kot32.ksimplelibrary.network.NetworkExecutor;

import java.util.HashMap;

/**
 * Created by kot32 on 15/11/8.
 */
public class TestApplication extends KSimpleApplication {


    private final static String SERVER_URL = "http://192.168.31.246:9090/";

    @Override
    public void startInit() {

    }

    @Override
    public void initLocalPreference(HashMap<String, ?> dataMap) {

    }

    @Override
    public void onInitLocalUserModelFailed() {

    }

    @Override
    public LoginTask getLoginTask() {

        HashMap<String, String> loginParams = new HashMap<>();
        Student student = (Student) getUserModel();
        if (student != null) {
            if (student.getUsername() != null) {
                loginParams.put("username", student.getUsername());
            }
            if (student.getPassword() != null) {
                loginParams.put("password", student.getPassword());
            }
        }
        return new LoginTask(getTaskTag(), this,
                LoginResponse.class, loginParams, SERVER_URL, NetworkTask.GET) {
            @Override
            public boolean isLoginSucceed(BaseResponse baseResponse) {
                LoginResponse loginResponse = (LoginResponse) baseResponse;
                if (loginResponse.getResponseCode() == 202) {
                    return true;
                }
                return false;
            }

            @Override
            public void onConnectFailed(NetworkExecutor.NetworkResult result) {

            }
        };
    }


}
