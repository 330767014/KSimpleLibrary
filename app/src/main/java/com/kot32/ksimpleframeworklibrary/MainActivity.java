package com.kot32.ksimpleframeworklibrary;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kot32.ksimpleframeworklibrary.fragment.TestListViewFragment;
import com.kot32.ksimpleframeworklibrary.fragment.TestWebViewFragment;
import com.kot32.ksimpleframeworklibrary.model.Student;
import com.kot32.ksimplelibrary.activity.i.IBaseAction;
import com.kot32.ksimplelibrary.activity.t.KTabActivity;
import com.kot32.ksimplelibrary.widgets.drawer.KDrawerBuilder;
import com.kot32.ksimplelibrary.widgets.drawer.component.DrawerComponent;
import com.kot32.ksimplelibrary.widgets.view.KTabBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends KTabActivity implements IBaseAction {

    private List<Fragment> fragmentList = new ArrayList<>();

    private Toolbar toolbar;

    private final static String AVATAR_URL = "http://img1.gamersky.com/image2015/03/20150313lr_1/gamersky_03small_06_20153171716F84.jpg";

    private DrawerLayout drawer;

    @Override
    public int initLocalData() {
        return 0;
    }

    @Override
    public void initView(ViewGroup view) {
        toolbar.setTitleTextColor(0xffffffff);

//        new KDrawerBuilder(this)
//                .withToolBar(toolbar)
//                .withCustomContentView(new DrawerMenu(this))
//                .withWidth(300)
//                .build();

        final DrawerComponent.DrawerHeader header = new DrawerComponent.DrawerHeader(DrawerComponent.DrawerHeader.DrawerHeaderStyle.NORMAL,
                R.drawable.drawer_theme_6_bg,
                this);
        header.addAvatar(R.drawable.avatar, AVATAR_URL, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断当前是否登录
                if (getSimpleApplicationContext().isLogined()) {
                    //do somehting
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    if(drawer!=null){
                        drawer.closeDrawers();
                    }
                }
            }
        });
        header.addNickName("未登录");
        header.addIntroduction("请点击默认头像登录");


        drawer = new KDrawerBuilder(this)
                .withToolBar(toolbar)
                .withWidth(300)
                .addDrawerHeader(header, null)
                .addDrawerSectionTitle("菜单", Color.DKGRAY)
                .addDrawerSubItem(R.drawable.ic_collected, "收藏", null, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了收藏", Toast.LENGTH_SHORT).show();
                    }
                })
                .addDrawerSubItem(R.drawable.ic_commented, "评论", null, null)
                .addDrawerSubItem(R.drawable.ic_drawer_explore_normal, "探索", null, null)
                .addDrawerSubItem(R.drawable.ic_register_normal, "注册", null, null)
                .addDrawerDivider(Color.parseColor("#f1f2f1"))
                .addDrawerSubItem("", "关于", null, null)
                .addDrawerSubItem("", "更多设置", null, null)
                .withDrawerAction(new KDrawerBuilder.DrawerAction() {
                    @Override
                    public void onDrawerOpened(View kDrawerView) {
                        //打开了侧滑菜单
                        if (getSimpleApplicationContext().isLogined()) {
                            Student student = (Student) getSimpleApplicationContext().getUserModel();
                            header.changeNickName(student.getUsername());
                            header.changeIntroduction("保持饥饿，保持愚蠢");
                        }
                    }

                    @Override
                    public void onDrawerClosed(View kDrawerView) {
                        //关闭了侧滑菜单
                    }
                })
                .build();



        setTitle("测试");
    }

    @Override
    public void initController() {
        addTab(R.mipmap.chats, R.mipmap.chats_green, "聊天", Color.GRAY, Color.parseColor("#04b00f"));
        addTab(R.mipmap.contacts, R.mipmap.contacts_green, "联系人", Color.GRAY, Color.parseColor("#04b00f"));
        addTab(R.mipmap.discover, R.mipmap.discover_green, "发现", Color.GRAY, Color.parseColor("#04b00f"));
        addTab(R.mipmap.about_me, R.mipmap.about_me_green, "我", Color.GRAY, Color.parseColor("#04b00f"));
    }

    @Override
    public void onLoadingNetworkData() {

    }

    @Override
    public void onLoadedNetworkData(View view) {

    }

    //设定样式为微信样式（可滑动，渐变）
    @Override
    public KTabBar.TabStyle getTabStyle() {
        return KTabBar.TabStyle.STYLE_GRADUAL;
    }

    @Override
    public List<Fragment> getFragmentList() {
        fragmentList.add(new TestWebViewFragment());
        fragmentList.add(new TestListViewFragment());
        fragmentList.add(new TestListViewFragment());
        fragmentList.add(new TestListViewFragment());
        return fragmentList;
    }

    @Override
    public View getCustomContentView(View v) {
        ViewGroup vg = (ViewGroup) super.getCustomContentView(v);
        toolbar = (Toolbar) getLayoutInflater().inflate(R.layout.default_toolbar, null);
        vg.addView(toolbar, 0);
        return vg;
    }
}
