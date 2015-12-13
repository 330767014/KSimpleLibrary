package com.kot32.ksimpleframeworklibrary.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kot32.ksimpleframeworklibrary.R;
import com.kot32.ksimpleframeworklibrary.adapter.TestListAdapter;
import com.kot32.ksimpleframeworklibrary.model.Student;
import com.kot32.ksimpleframeworklibrary.refresh.JDLoadMoreFootView;
import com.kot32.ksimpleframeworklibrary.refresh.JDRefreshHeaderView;
import com.kot32.ksimplelibrary.activity.i.IBaseAction;
import com.kot32.ksimplelibrary.fragment.t.KRefreshFragment;
import com.kot32.ksimplelibrary.widgets.view.KRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kot32 on 15/12/13.
 */
public class TestListViewFragment extends KRefreshFragment implements IBaseAction {

    private JDRefreshHeaderView jdRefreshHeaderView;

    private JDLoadMoreFootView jdLoadMoreFootView;

    private ListView listView;

    private List<Student> studentList;

    private TestListAdapter adapter;

    private static final String BD_URL = "https://github.com/";

    @Override
    public IBaseAction getIBaseAction() {
        return this;
    }


    @Override
    public int initLocalData() {
        studentList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            studentList.add(new Student("aa" + i, "aa" + i));
        }
        adapter = new TestListAdapter(getActivity(), studentList);
        return LOAD_NETWORK_DATA_AND_DISMISS;
    }

    @Override
    public void initView(ViewGroup view) {
        listView = (ListView) view.findViewById(R.id.listview);
        jdLoadMoreFootView = new JDLoadMoreFootView(getActivity());
    }

    @Override
    public void initController() {
        listView.setAdapter(adapter);
        initLoadMoreFunc();
    }

    @Override
    public void onLoadingNetworkData() {

    }

    @Override
    public void onLoadedNetworkData(View view) {

    }

    @Override
    public int getContentLayoutID() {
        return R.layout.fragment_test_listview;
    }

    @Override
    public View onRefresh() {

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

    @Override
    public KRefreshView.LoadMoreConfig getLoadMoreConfig() {
        return new KRefreshView.LoadMoreConfig(true, jdLoadMoreFootView, new KRefreshView.ILoadMoreAction() {
            @Override
            public void loadMore() {
                for (int i = 0; i <= 10; i++) {
                    studentList.add(new Student("aa" + i, "aa" + i));
                }
            }

            @Override
            public void loadMoreComplete() {
                adapter.notifyDataSetChanged();
            }
        }, jdLoadMoreFootView, 80);
    }
}
