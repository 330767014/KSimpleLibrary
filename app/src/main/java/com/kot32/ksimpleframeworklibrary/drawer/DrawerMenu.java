package com.kot32.ksimpleframeworklibrary.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.kot32.ksimpleframeworklibrary.R;
import com.kot32.ksimplelibrary.widgets.drawer.KDrawerContentLayout;

/**
 * Created by kot32 on 15/11/25.
 */
public class DrawerMenu extends KDrawerContentLayout {

    public DrawerMenu(Context context) {
        super(context);
    }

    public DrawerMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initDrawerController() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.drawer_menu;
    }

    @Override
    public void initViews(ViewGroup contentView) {

    }

    @Override
    public void updateViewOnDrawerOpened() {

    }

    @Override
    public void onDrawerClosed() {

    }

}
