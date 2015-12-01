package com.kot32.ksimpleframeworklibrary;

import android.app.ProgressDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kot32.ksimpleframeworklibrary.domain.LoginResponse;
import com.kot32.ksimplelibrary.activity.i.IBaseAction;
import com.kot32.ksimplelibrary.activity.t.base.KSimpleBaseActivityImpl;
import com.kot32.ksimplelibrary.manager.task.LoginTask;
import com.kot32.ksimplelibrary.manager.task.base.NetworkTask;
import com.kot32.ksimplelibrary.manager.task.base.SimpleTaskManager;
import com.kot32.ksimplelibrary.model.response.BaseResponse;
import com.kot32.ksimplelibrary.network.NetworkExecutor;

import java.util.HashMap;

/**
 *
 */
public class LoginActivity extends KSimpleBaseActivityImpl implements IBaseAction {

    private ProgressDialog progressDialog;
    private Button confirm;
    private HashMap<String, String> loginParams;

    private final static String SERVER_URL = "http://192.168.31.246:9090/";

    @Override
    public int initLocalData() {
        loginParams = new HashMap<>();
        loginParams.put("username", "kot32");
        loginParams.put("password", "12345678");
        return 0;
    }

    @Override
    public void initView(ViewGroup view) {
        confirm = (Button) view.findViewById(R.id.button);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("正在登录...");
    }

    @Override
    public void initController() {
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                SimpleTaskManager.startNewTask(new LoginTask(getTaskTag(), getSimpleApplicationContext(),
                        LoginResponse.class, loginParams, SERVER_URL, NetworkTask.GET) {
                    @Override
                    public void onConnectFailed(NetworkExecutor.NetworkResult result) {
                        progressDialog.dismiss();

                    }

                    @Override
                    public boolean isLoginSucceed(BaseResponse baseResponse) {
                        LoginResponse loginResponse = (LoginResponse) baseResponse;
                        if (loginResponse.getResponseCode() == 202) {
                            progressDialog.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public void onLoadingNetworkData() {

    }

    @Override
    public void onLoadedNetworkData(View view) {

    }

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_login;
    }

}

