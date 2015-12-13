package com.kot32.ksimpleframeworklibrary.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.kot32.ksimpleframeworklibrary.R;
import com.kot32.ksimpleframeworklibrary.refresh.JDRefreshHeaderView;
import com.kot32.ksimplelibrary.activity.i.IBaseAction;
import com.kot32.ksimplelibrary.fragment.t.KRefreshFragment;
import com.kot32.ksimplelibrary.widgets.view.KRefreshView;

/**
 * Created by kot32 on 15/11/4.
 */
public class TestWebViewFragment extends KRefreshFragment implements IBaseAction {

    private JDRefreshHeaderView jdRefreshHeaderView;

    private WebView webView;

    private static final String BD_URL = "https://github.com/";

    @Override
    public IBaseAction getIBaseAction() {
        return this;
    }


    @Override
    public int initLocalData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return LOAD_NETWORK_DATA_AND_DISMISS;
    }

    @Override
    public void initView(ViewGroup view) {
        webView = (WebView) view.findViewById(R.id.webview);
        webView.loadUrl(BD_URL);
    }

    @Override
    public void initController() {

    }

    @Override
    public void onLoadingNetworkData() {

    }

    @Override
    public void onLoadedNetworkData(View view) {

    }

    @Override
    public int getContentLayoutID() {
        return R.layout.fragment_test_webview;
    }

    @Override
    public View onRefresh() {
        //webview 需要在主线程刷新
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.reload();
            }
        });
        //刷新啦
        return null;
    }

    @Override
    public View onRefreshComplete() {
        //刷新完啦
        return null;
    }

    @Override
    public View customHeaderView() {
        jdRefreshHeaderView = new JDRefreshHeaderView(getActivity());
        return jdRefreshHeaderView;
    }

    @Override
    public void customRefreshView(KRefreshView refreshView) {
        refreshView.setRefreshViewHolder(jdRefreshHeaderView);
        refreshView.setHeaderHeight(80);
    }

}
